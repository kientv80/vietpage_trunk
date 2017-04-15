package com.vnsoft.server.actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

import org.apache.log4j.Logger;

import com.vnsoft.server.biz.CompanyBean;
import com.vnsoft.server.biz.FeedBean;
import com.vnsoft.server.biz.JDBCConnection;
import com.vnsoft.server.biz.MenuBean;
import com.vnsoft.server.model.CompanyInfo;
import com.vnsoft.server.model.Feed;
import com.vnsoft.server.model.Item;

public class ResizeImageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4195359982880241541L;
	Logger log = Logger.getLogger(ResizeImageAction.class);

	@Override
	public String execute() throws Exception {
		Connection con = null;
		Statement stm = null;
		ResultSet result = null;
		try {
			con = JDBCConnection.getInstance().getConnection();
			stm = con.createStatement();
			String imagePath = null;
			if (imagePath == null) {
				File f = new File("tmp.txt");
				imagePath = (f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 7));
			}

			String separatorChar = File.separator;
			
			if ("\\".equals(separatorChar)){
				separatorChar = separatorChar + separatorChar;
//				imagePath = imagePath.replace("\\", separatorChar);
			}
			String dir = imagePath +  "webapps" + separatorChar + "images" ;
			log.info("file dir===============" + dir);
			String fileName = "";
			for (CompanyInfo com : CompanyBean.getInstance().getAllPages()) {

				log.info("ContentImage()===============" + com.getContentImage());
				if (com.getContentImage() != null && com.getContentImage().lastIndexOf("/") > 0) {
					try {
						log.info("ContentImage()===============" + com.getContentImage());
						fileName = com.getContentImage().substring(com.getContentImage().lastIndexOf("/")+1, com.getContentImage().length());
						BufferedImage image = ImageIO.read(new File(dir + separatorChar+ com.getId()+ separatorChar + fileName));
						int rwidth = image.getWidth();
						int rheight = image.getHeight();
						if(rwidth > rheight){
							Thumbnails.of(dir + separatorChar + com.getId()+ separatorChar + fileName).size(330,200).crop(Positions.CENTER).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
						}else{
							Thumbnails.of(dir + separatorChar + com.getId()+ separatorChar + fileName).width(rwidth).height((int)((double)rheight*0.80)).crop(Positions.CENTER).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
							Thumbnails.of(dir + separatorChar + com.getId()+ separatorChar +"thumbnail."+fileName).width(300).height(200).crop(Positions.TOP_CENTER).outputFormat("jpg").toFiles(Rename.NO_CHANGE);
						}
						String imageUrl = com.getContentImage();
						String impagePath = imageUrl.substring(0,imageUrl.lastIndexOf("/")+1);
						String name = imageUrl.substring(imageUrl.lastIndexOf("/")+1,imageUrl.length());
						
						stm.executeUpdate("update company set thumb_center_image='"+impagePath+"thumbnail."+name+"' where id="+com.getId());
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
				/*if (com.getHeaderImage() != null && com.getHeaderImage().lastIndexOf("/") > 0) {
					try {
						log.info("HeaderImage()===============" + com.getHeaderImage());
						fileName = com.getHeaderImage().substring(com.getHeaderImage().lastIndexOf("/"), com.getHeaderImage().length());
						Thumbnails.of(dir + separatorChar + com.getId() + fileName).width(1024).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
						
						String imageUrl = com.getHeaderImage();
						String impagePath = imageUrl.substring(0,imageUrl.lastIndexOf("/")+1);
						String name = imageUrl.substring(imageUrl.lastIndexOf("/")+1,imageUrl.length());
						stm.executeUpdate("update company set thumb_header_image='"+impagePath+"thumbnail."+name+"' where id="+com.getId());
					
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}*/
				System.out.println("*************************" + com.getId());
				for (Item i : MenuBean.getInstance().getItems(Long.valueOf(com.getId()).intValue())) {

					if (i.getImagePath() != null && i.getImagePath().lastIndexOf("/") > 0) {
						try {
							log.info("ImagePath()===============" + i.getImagePath());
							fileName = i.getImagePath().substring(i.getImagePath().lastIndexOf("/")+1, i.getImagePath().length());
							System.out.println(dir + separatorChar + com.getId()+ separatorChar+fileName);
							
							BufferedImage image = ImageIO.read(new File(dir + separatorChar+ com.getId()+ separatorChar + fileName));
							int rwidth = image.getWidth();
							int rheight = image.getHeight();
							
							if(rwidth > rheight){
								Thumbnails.of(dir + separatorChar + com.getId()+ separatorChar+fileName).width(330).height(200).crop(Positions.CENTER).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
							}else{
								Thumbnails.of(dir + separatorChar + com.getId()+ separatorChar+fileName).width(rwidth).height((int)((double)rheight*0.80)).crop(Positions.CENTER).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
								Thumbnails.of(dir + separatorChar +com.getId()+ separatorChar+"thumbnail."+fileName).width(330).height(200).crop(Positions.TOP_CENTER).outputFormat("jpg").toFiles(Rename.NO_CHANGE);
							}
							Thumbnails.of(dir + separatorChar +com.getId()+ separatorChar+"thumbnail."+fileName).width(150).height(120).crop(Positions.CENTER).outputFormat("jpg").toFiles(Rename.PREFIX_HYPHEN_THUMBNAIL);
							
							String imageUrl = i.getImagePath();
							String impagePath = imageUrl.substring(0,imageUrl.lastIndexOf("/")+1);
							String name = imageUrl.substring(imageUrl.lastIndexOf("/")+1,imageUrl.length());
							
							stm.executeUpdate("update menuitem set thumb_item_image='"+impagePath+"thumbnail."+name+"' where id="+i.getId());
							System.out.println("END >>>>>>>>>>"+dir + separatorChar + com.getId()+ separatorChar+fileName);
						} catch (Exception e) {
							// TODO: handle exception
//							e.printStackTrace();
						}

					}
				}
			}
			for (Feed f : FeedBean.getInstance().getFeeds(100)) {
				if (f.getImage() != null && !f.getImage().isEmpty()) {
					if (f.getImage() != null && f.getImage().lastIndexOf("/") > 0) {
						try {
							log.info("f.getImage(()===============" + f.getImage());
							fileName = f.getImage().substring(f.getImage().lastIndexOf("/")+1, f.getImage().length());
							
						
							BufferedImage image = ImageIO.read(new File(dir + separatorChar + f.getComid() + separatorChar+ fileName));
							int rwidth = image.getWidth();
							int rheight = image.getHeight();
							String ext= fileName.substring(fileName.indexOf(".")+1,fileName.length());
							if(rwidth > rheight){
								Thumbnails.of(dir + separatorChar + f.getComid()+ separatorChar  + fileName).width(460).height(230).crop(Positions.CENTER).outputFormat(ext).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
								Thumbnails.of(dir + separatorChar+ f.getComid()+ separatorChar  +"thumbnail."+fileName).width(170).height(130).crop(Positions.CENTER).outputFormat(ext).toFiles(Rename.PREFIX_HYPHEN_THUMBNAIL);
							}else{
								Thumbnails.of(dir + separatorChar+ f.getComid()+ separatorChar  + fileName).width(rwidth).height((int)((double)rheight*0.85)).crop(Positions.CENTER).outputFormat(ext).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
								Thumbnails.of(dir + separatorChar+ f.getComid()+ separatorChar  +"thumbnail."+fileName).width(460).height(300).crop(Positions.TOP_CENTER).outputFormat(ext).toFiles(Rename.NO_CHANGE);
								
								Thumbnails.of(dir + separatorChar+ f.getComid()+ separatorChar  +"thumbnail."+fileName).width(170).height(130).crop(Positions.TOP_CENTER).outputFormat(ext).toFiles(Rename.PREFIX_HYPHEN_THUMBNAIL);
							}
							
							
							String imageUrl = f.getImage();
							String impagePath = imageUrl.substring(0,imageUrl.lastIndexOf("/")+1);
							String name = imageUrl.substring(imageUrl.lastIndexOf("/")+1,imageUrl.length());
							stm.executeUpdate("update feed set thumb1_image='"+impagePath+"thumbnail."+name+"', thumb2_image='"+impagePath+"thumbnail-thumbnail."+name+"' where id="+f.getId());
						
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result != null)
				result.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();

		}
		return SUCCESS;
	}

	public static void main(String[] args) {
		
		try {
			Thumbnails.of("D:\\Working\\projects\\vietpage_trunk\\webapps\\images\\45\\defaultItem1.jpg").width(330).height(200).crop(Positions.CENTER).outputFormat("jpg").toFiles(Rename.PREFIX_DOT_THUMBNAIL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
