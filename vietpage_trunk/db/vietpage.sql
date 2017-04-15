-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: vietpage
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Ho Chi Minh'),(2,'Ha Noi'),(3,'Hue'),(4,'Vung Tau'),(5,'Mui Ne'),(6,'Nha Trang'),(7,'Da Lat'),(8,'Hue'),(9,'Ha Long'),(10,'Kien Giang');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `comid` int(10) unsigned NOT NULL,
  `posteddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `emailofposter` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `postedby` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (30,1,'2013-11-03 17:00:00','Ngon phet','kienjudo@yahoo.com','test'),(31,1,'2013-11-03 17:00:00','Good','kienjudo@yahoo.com','kientrinh'),(32,43,'2013-11-03 17:00:00','Ngon','kienjudo@yahoo.com','kientrinh'),(33,43,'2013-11-03 17:00:00','Rat ngon','kienjudo@yahoo.com','kientrinh'),(34,43,'2013-11-03 17:00:00','Tuyet','kienjudo@yahoo.com','kientrinh'),(35,45,'2013-11-19 17:00:00','Good shop','kienjudo@yahoo.com','kientrinh'),(36,45,'2013-11-19 17:00:00','My lovely place','minh@vng.com','Pham Minh');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `headerimage` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `contentimage` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location_map_image` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location_id` int(10) unsigned DEFAULT NULL,
  `service_id` int(10) unsigned DEFAULT NULL,
  `ispublic` tinyint(1) NOT NULL DEFAULT '0',
  `isapprove` tinyint(1) NOT NULL DEFAULT '1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `owner_id` int(10) unsigned NOT NULL,
  `isreviewed` tinyint(1) NOT NULL DEFAULT '0',
  `max_item` int(10) unsigned NOT NULL DEFAULT '20',
  `phones` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addresses` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emails` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `providedservice` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `about` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Lookup',' ',' ',' ',' ',' ',0,NULL,1,0,'2013-10-26 13:05:20',15,1,100,NULL,NULL,NULL,NULL,''),(43,'TMK Fast Food','/mypage?page=tmkff','/images/43//defaultHeader.jpg','<strong>TMK Fast food</strong> là quán cung cấp đồ <span style=\"background-color: #ffff00;\">ăn nhanh</span> và <span style=\"background-color: #ffff00;\">cơm trưa văn phòng</span>. <br>Bên cạnh đó cung cấp <span style=\"background-color: #ffff40;\">các loại nước uống, trai cây dia </span>vvv.','/images/43//defaultContent.jpg','/images/43/TMK Fast Food_map_1380554914934.jpg',1,1,1,1,'2013-09-30 15:28:34',18,1,100,NULL,'Khu cong vien phan men quang trung, truoc nha 5','pham.nguyetminh@yahoo.com','Fast food TMK',''),(44,'Làng nướng nam bộ','http://nhahanglangnuongnambo.com','/images/44//defaultHeader.jpg','<strong>Giới thiệu nhà hàng Làng Nướng Nam Bộ</strong>\r\n<br>Nhà hàng làng nướng Nam Bộ với trên 100 món nướng dân dã đồng quê Nam bộ, khung cảnh thiên nhiên đồng quê thoáng mát, sân vườn rộng rãi, có phòng lạnh, phòng víp rất phù hợp cho Quý khách đặt tiệc cưới, liên hoan, sinh nhật, họp mặt (trên 100 bàn)...<br><br><strong>Chi nhánh:</strong><br><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">19B Nguyễn Thị Diệu, 6th Ward, Quận 3, Hồ Chí Minh, Việt Nam (</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">+84 8 3863 2309</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">)<br></span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">546 Cách Mạng Tháng 8, 11, Hồ Chí Minh, Việt Nam (</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">+84 8 3844 5525)<br></span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">4 Lý Thường Kiệt, 12, Hồ Chí Minh, Việt Nam (</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">+84 8 3855 4024)<br></span><span style=\"background-color: #fafafa; color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal;\">3 Hòa Bình, 3, Hồ Chí Minh, Việt Nam(</span><span style=\"background-color: #fafafa; color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal;\">+84 8 3963 1887)<br></span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">62 Bà Hom, 13, Hồ Chí Minh, Việt Nam(</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">+84 8 6293 0787)<br></span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">&nbsp;</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">318 Trường Chinh, 13, Tân Bình, Hồ Chí Minh, Việt Nam(</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">+84 8 3912 6866)<br></span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">36 Trần Quý Cáp, 11, Bình Thạnh, Hồ Chí Minh, Việt Nam(</span><span style=\"color: #222222; font-family: arial, sans-serif; font-size: small; line-height: normal; background-color: #fafafa;\">+84 8 3516 2084)</span>','/images/44//defaultContent.jpg','',13,1,1,1,'2013-10-01 06:39:04',19,1,100,'84 8 3863 2309','19B Nguyễn Thị Diệu, 6th Ward, Quận 3, Hồ Chí Minh, Việt Nam ','NA','Cung cap 100 mom nuong Nam Bo','Doc mo ta ve cong ty'),(45,'Hoàng Ty','http://www.hoangty.com.vn/contact.html','/images/45//defaultHeader.jpg','<strong style=\"color: #0060bf;\">Chào mừng quý khách đến với\r\nNhà Hàng HOÀNG TY<br></strong><br>&nbsp;Không phải ngẫu nhiên mà Nhà hàng Hoàng Ty luôn là điểm lựa chọn hàng đầu của quý khách, là nơi thưởng thức hơn 30 loại rau rất tốt cho sức khỏe với khẩu vị đặc biệt mà không nơi nào có nhờ đội ngũ đầu bếp nhiều kinh nghiệm của nhà hàng sẽ mang đến nhiều món ăn ngon, trình bày đẹp mắt, để lại dư âm tốt đẹp trong lòng thực khách đến dự tiệc...<br><br><p style=\"line-height: 22px; font-family: Tahoma, \'Trebuchet MS\', Arial, Helvetica, sans-serif; font-size: 13px; text-align: center;\"><strong>459-461 CMT8 , P13, Q10</strong><br><strong>78-80-82 Hoàng Văn Thụ , P9, Q. Phú Nhuận</strong><br><strong>447-449-451 đường số 7 (khu tên lửa), P. Bình trị đông B, Q. Bình Tân</strong></p><p style=\"line-height: 22px; font-family: Tahoma, \'Trebuchet MS\', Arial, Helvetica, sans-serif; font-size: 13px; text-align: center;\"><strong>Mọi chi tiết xin liên hệ số điện thoại 0908449118<br>----------------------------------------------------------------------------------------<br>692B/9 + 10 Bình Quới P.27 QBT<br>850 Bình Quới P.28 QBT</strong></p>','/images/45//defaultContent.jpg','',13,1,1,1,'2013-10-01 11:17:47',20,1,100,NULL,NULL,NULL,NULL,''),(46,'Beefsteak Nam Sơn','http://namsonsteak.com','/images/46//defaultHeader.jpg','<h2 style=\"margin: 0px 0px 0px 1px; padding: 0px 0px 12px; border: 0px; outline: 0px; color: #1a1a1a; font-size: 26px; line-height: normal; font-family: Arial; height: auto; font-weight: normal;\">Chào mừng<br><span class=\"sub-h2\" style=\"margin: 0px; padding: 0px; border: 0px; outline: 0px; font-size: 22px;\">đến với Nam Sơn</span></h2>Nam Sơn Quán với các món bò né, bít tết... đã khá quen thuộc với người dân Sài Gòn. Với các món truyền thống như Beefsteak, Opla, xíu mại, Pate, Nui xào, cơm gà,... được chế biến rất công phu mang theo hương vị Ấu Á giao hòa... chính điều này đã mang khách đến với Nam Sơn.\r\n\r\nBò bít tết\r\nBít tết Đà Điểu\r\nBít tết bò Mỹ\r\nBún bò Huế\r\nBánh căn hải sản\r\nBánh bèo\r\nCơm gà / Gà rán\r\nNui xào bò<br><br><span style=\"color: #373737; font-family: Arial, Helvetica, sans-serif; font-size: 11px; line-height: normal;\">Address 1: 200 Bis Nguyễn Thị Minh Khai, F.6, Q.3, Tp.HCM</span><br><span style=\"color: #373737; font-family: Arial, Helvetica, sans-serif; font-size: 11px; line-height: normal;\">Address 2: 157 Nam Kỳ Khởi Nghĩa,</span><br><span style=\"color: #373737; font-family: Arial, Helvetica, sans-serif; font-size: 11px; line-height: normal;\">F.6, Q.3, Tp.HCM</span>','/images/46//defaultContent.jpg','',6,1,1,1,'2013-10-02 15:50:10',21,1,100,NULL,NULL,NULL,NULL,''),(47,'MyPage','','','',NULL,NULL,NULL,NULL,1,0,'2013-10-26 13:04:04',15,1,1000,NULL,NULL,NULL,NULL,'');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotnews`
--

DROP TABLE IF EXISTS `hotnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotnews` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `link` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `thume` varchar(100) CHARACTER SET latin1 NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotnews`
--

LOCK TABLES `hotnews` WRITE;
/*!40000 ALTER TABLE `hotnews` DISABLE KEYS */;
INSERT INTO `hotnews` VALUES (3,'http://tuoitre.vn/The-gioi/579585/thu-truong-cong-nghiep-iran-bi-am-sat-ngay-o-tehran.html','11/11/2013 14:28 (GMT + 7)\r\nTTO - Ngày 11-11, truyền thông Iran đưa tin Thứ trưởng Công nghiệp Safdar Rahmat Abadi đã bị một kẻ không rõ danh tính bắn chết ngay tại Tehran (thủ đô Iran). Đây là vụ sát hại quan chức cấp cao ở Iran đầu tiên trong nhiều năm qua.','/images/hotnews/thume_1384075218846.jpg','2013-11-10 09:20:18','Thứ trưởng Công nghiệp Iran bị ám sát ngay ở Tehran'),(4,'http://nld.com.vn/thoi-su-quoc-te.htm','10:48:15 11/11/2013\r\nVới đầu đề \"Nga - Việt Nam: Cùng nhau đi tới những chân trời hợp tác mới\", Tổng thống Nga Vladimir Putin đã có bài viết về sự phát triển quan hệ song phương trước thềm chuyến thăm Việt Nam vào ngày 12-11 theo lời mời của Chủ tịch nước Trương Tấn Sang.','/images/hotnews/thume_1384075546134.jpg','2013-11-10 09:25:46','Tổng thống Putin ca ngợi quan hệ Việt - Nga'),(5,'http://tuoitre.vn/The-gioi/579595/the-gioi-chia-se-dau-thuong-philippines.html','11/11/2013 15:38 (GMT + 7)\r\nTTO - Nhiều nước và nhiều tổ chức trên thế giới đã nhanh chóng gửi nhân lực cùng đồ tiếp tế đến các khu vực bị siêu bão Haiyan tàn phá nặng nề ở Philippines.','/images/hotnews/thume_1384075585635.jpg','2013-11-10 09:26:25','Thế giới chia sẻ đau thương Philippines'),(6,'http://nld.com.vn/thoi-su-quoc-te/trieu-tien-xu-tu-80-nguoi-vi-xem-phim-han-2013111104022256.htm','16:38:45 11/11/2013\r\n(NLĐO) – Tờ JoongAng Ilbo dẫn nguồn tin “thân cận” với Bộ Nội vụ Triều Tiên cho biết khoảng 80 người bị tử hình vì tội xem phim Hàn Quốc hồi đầu tháng này.','/images/hotnews/thume_1384185809861.jpg','2013-11-11 16:03:29','Triều Tiên \"xử tử 80 người vì xem phim Hàn\"'),(7,'http://nld.com.vn/thoi-su-quoc-te/may-bay-boc-chay-khi-ha-canh-5-nguoi-chet-20131111044931756.htm','17:21:18 11/11/2013\r\n(NLĐO) – 5 người thiệt mạng và chỉ có 2 người sống sót khi chiếc máy bay cỡ nhỏ 19 chỗ ngồi phát nổ rồi bốc cháy khi hạ cánh tại một vùng nông thôn của tỉnh Ontario – Canada vào tối 10-11.','/images/hotnews/thume_1384185907315.jpg','2013-11-11 16:05:07','Máy bay bốc cháy khi hạ cánh, 5 người chết');
/*!40000 ALTER TABLE `hotnews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `city_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Quang Trung Software City',1),(2,'ETown',1),(3,'EHome',1),(4,'Quan 1',1),(5,'Quan 2',1),(6,'Quan 3',1),(7,'Quan 4',1),(8,'Quan 5',1),(9,'Quan 6',1),(10,'Quan 7',1),(11,'Quan 8',1),(12,'Quan 9',1),(13,'Quan 10',1),(14,'Quan 11',1),(15,'Quan 12',1),(16,'Quan Thu Duc',1),(17,'Hoc Mon',1),(18,'Khu Cong Nghe Cao',1),(19,'Tan Binh',1),(20,'Trung Tâm Thành phố',2),(21,'Huyện Ba Vì',2),(22,'Huyện Chương Mỹ',2),(23,'Ke Ga',5),(24,'Binh Tan',1),(25,'Binh Thanh',1),(26,'Go Vap',1),(27,'Phu Nhuan',1),(28,'Tan Phu',1),(29,'Binh Chanh',1),(30,'Can Gio',1),(31,'Cu Chi',1),(32,'Nha Be',1),(33,'Phuong 1',4),(34,'Phuong 2',4),(35,'Phuong 3',4),(36,'Phuong 4',4),(37,'Phuong 5',4),(38,'Phuong 6',4),(39,'Phuong 7',4),(40,'Phuong 8',4),(41,'Phuong 9',4),(42,'Phuong 10',4),(43,'Phuong 11',4),(44,'Phuong 12',4),(45,'Phường Nguyễn An Ninh',4),(46,'Phường Rạch Dừa',4),(47,'Phường Thắng Nhất',4),(48,'Phường Thắng Tam',4),(49,'Xã Long Sơn',4),(50,'Huyện Đan Phượng',2),(51,'Huyện Đông Anh',2),(52,'Huyện Gia Lâm',2),(53,'Huyện Hoài Đức',2),(54,'Huyện Mê Linh',2),(55,'Huyện Mỹ Đức',2),(56,'Huyện Phú Xuyên',2),(57,'Huyện Phúc Thọ',2),(58,'Huyện Quốc Oai',2),(59,'Huyện Sóc Sơn',2),(60,'Huyện Thạch Thất',2),(61,'Huyện Thanh Oai',2),(62,'Huyện Thanh Trì',2),(63,'Huyện Thường Tín',2),(64,'Huyện Từ Liêm',2),(65,'Huyện ứng Hòa',2),(66,'Quận Ba Đình',2),(67,'Quận Cầu Giấy',2),(68,'Quận Đống Đa',2),(69,'Quận Hà Đông',2),(70,'Quận Hai Bà Trưng',2),(71,'Quận Hoàn Kiếm',2),(72,'Quận Hoàng Mai',2),(73,'Quận Long Biên',2),(74,'Quận Tây Hồ',2),(75,'Quận Thanh Xuân',2),(76,'Thị xã Sơn Tây',2);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `comid` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (266,'All','Tấ cả đồ ăn phục vụ tại TMK',43),(269,'Menu','Menu các món ăn',44),(271,'Menu','Menu',45),(273,'Main Menu','Main Menu',46),(274,'ExampleCatalogue','Example Catalogue',47);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_menuitem`
--

DROP TABLE IF EXISTS `menu_menuitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_menuitem` (
  `menu_id` int(10) unsigned NOT NULL,
  `menu_item_id` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_menuitem`
--

LOCK TABLES `menu_menuitem` WRITE;
/*!40000 ALTER TABLE `menu_menuitem` DISABLE KEYS */;
INSERT INTO `menu_menuitem` VALUES (266,76,142),(266,72,143),(266,73,144),(266,74,145),(266,75,146),(269,79,152),(269,77,153),(269,81,154),(269,78,155),(269,80,156),(271,86,165),(271,85,166),(271,82,167),(271,83,168),(271,87,169),(271,84,170),(271,88,171),(271,89,172),(273,91,178),(273,92,179),(273,90,180),(273,93,181),(273,94,182),(274,98,186),(274,99,187);
/*!40000 ALTER TABLE `menu_menuitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuitem`
--

DROP TABLE IF EXISTS `menuitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menuitem` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `price` double NOT NULL,
  `image` varchar(1000) CHARACTER SET latin1 NOT NULL,
  `ismain` tinyint(1) NOT NULL,
  `comid` int(10) unsigned DEFAULT NULL,
  `isitemfortoday` tinyint(1) DEFAULT NULL,
  `isdiscount` tinyint(1) DEFAULT NULL,
  `discount_percent` int(10) unsigned DEFAULT NULL,
  `new_price` double DEFAULT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuitem`
--

LOCK TABLES `menuitem` WRITE;
/*!40000 ALTER TABLE `menuitem` DISABLE KEYS */;
INSERT INTO `menuitem` VALUES (72,'Cơm Đùi Gà','Cơm Đùi Gà Chiên',20000,'/images/defaultItem1.jpg',1,43,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(73,'Hamburger ','Hamburger bò, gà, trứng',15000,'/images/43/defaultItem2.jpg',1,43,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(74,'Sinh Tố','Sinh tố các loại',15000,'/images/43/defaultItem3.jpg',1,43,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(75,'Trái Cây Dĩa','Trái cây dĩa các loại.',15000,'/images/43/defaultItem4.jpg',1,43,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(76,'Coffee','Coffee đen, nâu các loại',10000,'/images/43/defaultItem5.jpg',1,43,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(77,'Cá tai tượng chiên xù','Cá tai tượng chiên xù',300000,'/images/44/defaultItem1.jpg',1,44,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(78,'Gà nướng lu, xôi chiên','Gà nướng lu, xôi chiên',450000,'/images/44/defaultItem2.jpg',1,44,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(79,'Bồ câu quay nam bộ','Bồ câu quay nam bộ 3 con',370000,'/images/44/defaultItem3.jpg',1,44,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(80,'Heo sữa quay','Heo sữa quay\r\nGia theo thời giá',0,'/images/44/defaultItem4.jpg',1,44,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(81,'Cơm nam bộ','Cơm nam bộ(giá theo thời giá)',0,'/images/44/defaultItem5.jpg',1,44,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(82,'Bánh tráng, thịt heo luộc','Bánh tráng, thịt heo luộc\r\nGiá: theo thời giá',0,'/images/45/defaultItem1.jpg',1,45,NULL,1,10,50000,'2013-10-03 17:00:00','2013-10-19 17:28:17',NULL),(83,'Bê luộc củ chi','Bê luộc củ chi\r\nGia: theo thời giá',0,'/images/45/defaultItem2.jpg',0,45,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(84,'Bắp heo, tôm chua','Bắp heo, tôm chua\r\nGiá:thời giá',0,'/images/45/defaultItem3.jpg',0,45,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(85,'Bánh canhg giò heo','Bánh canh giò heo',0,'/images/45/defaultItem4.jpg',1,45,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(86,'Bánh canh chả cá','Bánh canh chả cá',0,'/images/45/defaultItem5.jpg',0,45,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(87,'Bún bò huế','Bún bò huế',0,'/images/45/header_1380627286124.jpg',1,45,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(88,'Cá lóc chiên xù','Cá lóc chiên xù',0,'/images/45/header_1380627325795.jpg',1,45,NULL,1,20,40000,'2013-10-03 17:00:00','2013-10-19 17:28:17',NULL),(89,'Cá tai tượng chiên xù','Cá tai tượng chiên xù',0,'/images/45/header_1380627363374.jpg',1,45,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(90,'Bò bít bết','Bò bít bết',55000,'/images/46/defaultItem1.jpg',1,46,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(91,'Bít bết Trứng','Bít bết Trứng',55000,'/images/46/defaultItem2.jpg',1,46,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(92,'Bít bết thậm cẩm','Bít bết thậm cẩm',60000,'/images/46/defaultItem3.jpg',1,46,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(93,'Bún bò huế','Bún bò huế',45000,'/images/46/defaultItem4.jpg',1,46,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL),(94,'Cơm gà, gà rán','Cơm gà, gà rán',55000,'/images/46/defaultItem5.jpg',1,46,NULL,NULL,NULL,NULL,'2013-11-20 06:08:00','2013-10-19 17:28:17',NULL);
/*!40000 ALTER TABLE `menuitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `comid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (36,'2013-09-29 17:00:00','Từ 1/6/2013, TMK chính thức bán cơm trưa văn phòng.\r\nRất mong được quý khách ủng hộ. ',43),(37,'2013-11-08 17:00:00','Lang nuong nam bo da co website tren Viet Page.',44),(38,'2013-09-30 17:00:00','No news today.',45),(39,'2013-10-01 17:00:00','No news today.',46),(40,'2013-10-02 17:00:00','No news today.',47),(43,'2013-10-02 17:00:00',' Welcome to asfsada',50);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicetype`
--

DROP TABLE IF EXISTS `servicetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicetype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicetype`
--

LOCK TABLES `servicetype` WRITE;
/*!40000 ALTER TABLE `servicetype` DISABLE KEYS */;
INSERT INTO `servicetype` VALUES (1,'An, Uong'),(2,'Khach San'),(3,'Du Lich'),(4,'Taxi');
/*!40000 ALTER TABLE `servicetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trk_page_visit`
--

DROP TABLE IF EXISTS `trk_page_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trk_page_visit` (
  `id` varchar(100) CHARACTER SET latin1 NOT NULL,
  `visit_count` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trk_page_visit`
--

LOCK TABLES `trk_page_visit` WRITE;
/*!40000 ALTER TABLE `trk_page_visit` DISABLE KEYS */;
INSERT INTO `trk_page_visit` VALUES ('-1_2013-11',4),('-1_2013-11-19',1),('-1_2013-11-19 23',1),('-1_2013-11-19-04',1),('-1_2013-11-20',3),('-1_2013-11-20 10',3),('-1_2013-11-20-04',3),('1_2013-10',31),('1_2013-10-26',8),('1_2013-10-26 22',8),('1_2013-10-26-04',8),('1_2013-10-28',8),('1_2013-10-28 23',8),('1_2013-10-28-05',8),('1_2013-10-29',6),('1_2013-10-29 18',6),('1_2013-10-29-05',6),('1_2013-10-31',9),('1_2013-10-31 16',6),('1_2013-10-31 17',1),('1_2013-10-31 21',2),('1_2013-10-31-05',9),('1_2013-11',117),('1_2013-11-01',48),('1_2013-11-01 16',2),('1_2013-11-01 18',9),('1_2013-11-01 22',22),('1_2013-11-01 23',15),('1_2013-11-01-01',48),('1_2013-11-03',33),('1_2013-11-03 00',5),('1_2013-11-03 09',7),('1_2013-11-03 10',16),('1_2013-11-03 11',5),('1_2013-11-03-02',33),('1_2013-11-04',9),('1_2013-11-04 00',7),('1_2013-11-04 19',2),('1_2013-11-04-02',9),('1_2013-11-05',3),('1_2013-11-05 13',2),('1_2013-11-05 16',1),('1_2013-11-05-02',3),('1_2013-11-07',4),('1_2013-11-07 11',2),('1_2013-11-07 12',1),('1_2013-11-07 18',1),('1_2013-11-07-02',4),('1_2013-11-08',4),('1_2013-11-08 17',1),('1_2013-11-08 22',1),('1_2013-11-08 23',2),('1_2013-11-08-02',4),('1_2013-11-09',5),('1_2013-11-09 00',2),('1_2013-11-09 23',3),('1_2013-11-09-02',5),('1_2013-11-10',2),('1_2013-11-10 10',2),('1_2013-11-10-03',2),('1_2013-11-11',1),('1_2013-11-11 22',1),('1_2013-11-11-03',1),('1_2013-11-12',2),('1_2013-11-12 23',2),('1_2013-11-12-03',2),('1_2013-11-13',1),('1_2013-11-13 23',1),('1_2013-11-13-03',1),('1_2013-11-14',5),('1_2013-11-14 11',5),('1_2013-11-14-03',5),('41_2013-09',4),('41_2013-09-03',4),('41_2013-09-03 23',4),('41_2013-09-03-01',4),('41_2013-10',210),('41_2013-10-22',11),('41_2013-10-22 23',11),('41_2013-10-22-04',11),('41_2013-10-23',5),('41_2013-10-23 23',5),('41_2013-10-23-04',5),('41_2013-10-24',78),('41_2013-10-24 20',5),('41_2013-10-24 21',4),('41_2013-10-24 22',12),('41_2013-10-24 23',57),('41_2013-10-24-04',78),('41_2013-10-25',84),('41_2013-10-25 13',83),('41_2013-10-25 18',1),('41_2013-10-25-04',84),('41_2013-10-26',3),('41_2013-10-26 20',2),('41_2013-10-26 21',1),('41_2013-10-26-04',3),('41_2013-10-28',2),('41_2013-10-28 23',2),('41_2013-10-28-05',2),('41_2013-10-29',10),('41_2013-10-29 18',10),('41_2013-10-29-05',10),('41_2013-10-31',17),('41_2013-10-31 16',12),('41_2013-10-31 17',4),('41_2013-10-31 22',1),('41_2013-10-31-05',17),('41_2013-11',821),('41_2013-11-01',21),('41_2013-11-01 00',1),('41_2013-11-01 16',1),('41_2013-11-01 23',19),('41_2013-11-01-01',21),('41_2013-11-02',17),('41_2013-11-02 12',17),('41_2013-11-02-01',17),('41_2013-11-03',113),('41_2013-11-03 09',2),('41_2013-11-03 10',3),('41_2013-11-03 11',21),('41_2013-11-03 16',14),('41_2013-11-03 17',30),('41_2013-11-03 18',2),('41_2013-11-03 22',9),('41_2013-11-03 23',32),('41_2013-11-03-02',113),('41_2013-11-04',36),('41_2013-11-04 00',5),('41_2013-11-04 17',8),('41_2013-11-04 18',18),('41_2013-11-04 19',5),('41_2013-11-04-02',36),('41_2013-11-05',41),('41_2013-11-05 00',11),('41_2013-11-05 10',2),('41_2013-11-05 11',3),('41_2013-11-05 12',25),('41_2013-11-05-02',41),('41_2013-11-06',102),('41_2013-11-06 11',1),('41_2013-11-06 13',2),('41_2013-11-06 14',4),('41_2013-11-06 15',14),('41_2013-11-06 16',4),('41_2013-11-06 17',70),('41_2013-11-06 18',7),('41_2013-11-06-02',102),('41_2013-11-07',80),('41_2013-11-07 00',2),('41_2013-11-07 09',3),('41_2013-11-07 10',16),('41_2013-11-07 11',11),('41_2013-11-07 13',2),('41_2013-11-07 14',11),('41_2013-11-07 17',15),('41_2013-11-07 18',12),('41_2013-11-07 22',7),('41_2013-11-07 23',1),('41_2013-11-07-02',80),('41_2013-11-08',48),('41_2013-11-08 13',4),('41_2013-11-08 14',3),('41_2013-11-08 15',3),('41_2013-11-08 16',1),('41_2013-11-08 17',1),('41_2013-11-08 18',8),('41_2013-11-08 19',2),('41_2013-11-08 21',6),('41_2013-11-08 22',13),('41_2013-11-08 23',7),('41_2013-11-08-02',48),('41_2013-11-09',9),('41_2013-11-09 14',1),('41_2013-11-09 15',2),('41_2013-11-09 16',4),('41_2013-11-09 22',1),('41_2013-11-09 23',1),('41_2013-11-09-02',9),('41_2013-11-10',268),('41_2013-11-10 10',4),('41_2013-11-10 11',183),('41_2013-11-10 12',81),('41_2013-11-10-03',268),('41_2013-11-11',1),('41_2013-11-11 22',1),('41_2013-11-11-03',1),('41_2013-11-12',10),('41_2013-11-12 19',3),('41_2013-11-12 23',7),('41_2013-11-12-03',10),('41_2013-11-13',1),('41_2013-11-13 13',1),('41_2013-11-13-03',1),('41_2013-11-14',36),('41_2013-11-14 10',1),('41_2013-11-14 11',2),('41_2013-11-14 16',9),('41_2013-11-14 17',15),('41_2013-11-14 22',1),('41_2013-11-14 23',8),('41_2013-11-14-03',36),('41_2013-11-15',6),('41_2013-11-15 22',5),('41_2013-11-15 23',1),('41_2013-11-15-03',6),('41_2013-11-16',7),('41_2013-11-16 00',6),('41_2013-11-16 01',1),('41_2013-11-16-03',7),('41_2013-11-17',24),('41_2013-11-17 00',15),('41_2013-11-17 01',9),('41_2013-11-17-04',24),('41_2013-11-18',1),('41_2013-11-18 23',1),('41_2013-11-18-04',1),('42_2013-10',2),('42_2013-10-31',2),('42_2013-10-31 22',2),('42_2013-10-31-05',2),('42_2013-11',164),('42_2013-11-01',1),('42_2013-11-01 16',1),('42_2013-11-01-01',1),('42_2013-11-02',1),('42_2013-11-02 12',1),('42_2013-11-02-01',1),('42_2013-11-03',1),('42_2013-11-03 11',1),('42_2013-11-03-02',1),('42_2013-11-04',40),('42_2013-11-04 00',2),('42_2013-11-04 22',2),('42_2013-11-04 23',36),('42_2013-11-04-02',40),('42_2013-11-05',6),('42_2013-11-05 00',2),('42_2013-11-05 12',4),('42_2013-11-05-02',6),('42_2013-11-06',1),('42_2013-11-06 13',1),('42_2013-11-06-02',1),('42_2013-11-07',6),('42_2013-11-07 11',6),('42_2013-11-07-02',6),('42_2013-11-08',19),('42_2013-11-08 17',3),('42_2013-11-08 18',2),('42_2013-11-08 19',1),('42_2013-11-08 21',5),('42_2013-11-08 22',7),('42_2013-11-08 23',1),('42_2013-11-08-02',19),('42_2013-11-09',40),('42_2013-11-09 00',3),('42_2013-11-09 14',3),('42_2013-11-09 16',31),('42_2013-11-09 23',3),('42_2013-11-09-02',40),('42_2013-11-12',6),('42_2013-11-12 17',2),('42_2013-11-12 23',4),('42_2013-11-12-03',6),('42_2013-11-14',19),('42_2013-11-14 11',2),('42_2013-11-14 23',17),('42_2013-11-14-03',19),('42_2013-11-15',4),('42_2013-11-15 11',4),('42_2013-11-15-03',4),('42_2013-11-16',17),('42_2013-11-16 00',13),('42_2013-11-16 01',4),('42_2013-11-16-03',17),('42_2013-11-17',3),('42_2013-11-17 00',2),('42_2013-11-17 01',1),('42_2013-11-17-04',3),('43_2013-10',1),('43_2013-10-31',1),('43_2013-10-31 16',1),('43_2013-10-31-05',1),('43_2013-11',36),('43_2013-11-01',2),('43_2013-11-01 16',1),('43_2013-11-01 18',1),('43_2013-11-01-01',2),('43_2013-11-02',2),('43_2013-11-02 23',2),('43_2013-11-02-01',2),('43_2013-11-04',7),('43_2013-11-04 00',7),('43_2013-11-04-02',7),('43_2013-11-08',1),('43_2013-11-08 22',1),('43_2013-11-08-02',1),('43_2013-11-09',1),('43_2013-11-09 00',1),('43_2013-11-09-02',1),('43_2013-11-10',2),('43_2013-11-10 11',2),('43_2013-11-10-03',2),('43_2013-11-14',6),('43_2013-11-14 11',6),('43_2013-11-14-03',6),('43_2013-11-16',2),('43_2013-11-16 01',2),('43_2013-11-16-03',2),('43_2013-11-17',4),('43_2013-11-17 00',4),('43_2013-11-17-04',4),('43_2013-11-20',9),('43_2013-11-20 10',7),('43_2013-11-20 11',1),('43_2013-11-20 12',1),('43_2013-11-20-04',9),('44_2013-10',43),('44_2013-10-25',41),('44_2013-10-25 00',9),('44_2013-10-25 13',32),('44_2013-10-25-04',41),('44_2013-10-29',1),('44_2013-10-29 18',1),('44_2013-10-29-05',1),('44_2013-10-31',1),('44_2013-10-31 21',1),('44_2013-10-31-05',1),('44_2013-11',179),('44_2013-11-01',1),('44_2013-11-01 18',1),('44_2013-11-01-01',1),('44_2013-11-03',3),('44_2013-11-03 10',1),('44_2013-11-03 11',2),('44_2013-11-03-02',3),('44_2013-11-04',3),('44_2013-11-04 00',3),('44_2013-11-04-02',3),('44_2013-11-05',16),('44_2013-11-05 13',12),('44_2013-11-05 16',3),('44_2013-11-05 18',1),('44_2013-11-05-02',16),('44_2013-11-06',1),('44_2013-11-06 09',1),('44_2013-11-06-02',1),('44_2013-11-07',5),('44_2013-11-07 11',1),('44_2013-11-07 12',2),('44_2013-11-07 18',2),('44_2013-11-07-02',5),('44_2013-11-09',27),('44_2013-11-09 15',8),('44_2013-11-09 16',16),('44_2013-11-09 23',3),('44_2013-11-09-02',27),('44_2013-11-10',7),('44_2013-11-10 10',6),('44_2013-11-10 14',1),('44_2013-11-10-03',7),('44_2013-11-12',11),('44_2013-11-12 19',11),('44_2013-11-12-03',11),('44_2013-11-13',16),('44_2013-11-13 22',8),('44_2013-11-13 23',8),('44_2013-11-13-03',16),('44_2013-11-14',11),('44_2013-11-14 10',8),('44_2013-11-14 11',1),('44_2013-11-14 23',2),('44_2013-11-14-03',11),('44_2013-11-15',68),('44_2013-11-15 10',13),('44_2013-11-15 11',34),('44_2013-11-15 12',1),('44_2013-11-15 17',1),('44_2013-11-15 23',19),('44_2013-11-15-03',68),('44_2013-11-16',1),('44_2013-11-16 00',1),('44_2013-11-16-03',1),('44_2013-11-19',1),('44_2013-11-19 23',1),('44_2013-11-19-04',1),('44_2013-11-20',8),('44_2013-11-20 11',4),('44_2013-11-20 12',4),('44_2013-11-20-04',8),('45_2013-10',5),('45_2013-10-26',1),('45_2013-10-26 22',1),('45_2013-10-26-04',1),('45_2013-10-28',2),('45_2013-10-28 23',2),('45_2013-10-28-05',2),('45_2013-10-31',2),('45_2013-10-31 16',1),('45_2013-10-31 22',1),('45_2013-10-31-05',2),('45_2013-11',98),('45_2013-11-01',3),('45_2013-11-01 23',3),('45_2013-11-01-01',3),('45_2013-11-02',2),('45_2013-11-02 23',2),('45_2013-11-02-01',2),('45_2013-11-03',4),('45_2013-11-03 09',2),('45_2013-11-03 11',2),('45_2013-11-03-02',4),('45_2013-11-04',1),('45_2013-11-04 00',1),('45_2013-11-04-02',1),('45_2013-11-10',5),('45_2013-11-10 10',3),('45_2013-11-10 12',1),('45_2013-11-10 15',1),('45_2013-11-10-03',5),('45_2013-11-12',6),('45_2013-11-12 23',6),('45_2013-11-12-03',6),('45_2013-11-14',13),('45_2013-11-14 22',5),('45_2013-11-14 23',8),('45_2013-11-14-03',13),('45_2013-11-15',7),('45_2013-11-15 09',4),('45_2013-11-15 10',3),('45_2013-11-15-03',7),('45_2013-11-17',22),('45_2013-11-17 00',12),('45_2013-11-17 01',10),('45_2013-11-17-04',22),('45_2013-11-20',35),('45_2013-11-20 10',1),('45_2013-11-20 11',9),('45_2013-11-20 12',24),('45_2013-11-20 13',1),('45_2013-11-20-04',35),('46_2013-10',12),('46_2013-10-25',11),('46_2013-10-25 00',11),('46_2013-10-25-04',11),('46_2013-10-29',1),('46_2013-10-29 18',1),('46_2013-10-29-05',1),('46_2013-11',18),('46_2013-11-01',5),('46_2013-11-01 00',1),('46_2013-11-01 18',1),('46_2013-11-01 22',2),('46_2013-11-01 23',1),('46_2013-11-01-01',5),('46_2013-11-06',2),('46_2013-11-06 15',2),('46_2013-11-06-02',2),('46_2013-11-08',1),('46_2013-11-08 17',1),('46_2013-11-08-02',1),('46_2013-11-09',1),('46_2013-11-09 00',1),('46_2013-11-09-02',1),('46_2013-11-10',1),('46_2013-11-10 10',1),('46_2013-11-10-03',1),('46_2013-11-15',5),('46_2013-11-15 11',5),('46_2013-11-15-03',5),('46_2013-11-20',3),('46_2013-11-20 12',3),('46_2013-11-20-04',3),('47_2013-10',59),('47_2013-10-26',15),('47_2013-10-26 20',1),('47_2013-10-26 22',14),('47_2013-10-26-04',15),('47_2013-10-28',2),('47_2013-10-28 23',2),('47_2013-10-28-05',2),('47_2013-10-29',8),('47_2013-10-29 18',8),('47_2013-10-29-05',8),('47_2013-10-30',1),('47_2013-10-30 14',1),('47_2013-10-30-05',1),('47_2013-10-31',33),('47_2013-10-31 16',12),('47_2013-10-31 22',21),('47_2013-10-31-05',33),('47_2013-11',916),('47_2013-11-01',481),('47_2013-11-01 00',1),('47_2013-11-01 12',2),('47_2013-11-01 13',73),('47_2013-11-01 14',48),('47_2013-11-01 15',52),('47_2013-11-01 16',73),('47_2013-11-01 18',57),('47_2013-11-01 21',11),('47_2013-11-01 22',50),('47_2013-11-01 23',114),('47_2013-11-01-01',481),('47_2013-11-02',56),('47_2013-11-02 11',1),('47_2013-11-02 12',3),('47_2013-11-02 23',52),('47_2013-11-02-01',56),('47_2013-11-03',62),('47_2013-11-03 00',34),('47_2013-11-03 09',7),('47_2013-11-03 11',13),('47_2013-11-03 23',8),('47_2013-11-03-02',62),('47_2013-11-04',22),('47_2013-11-04 00',21),('47_2013-11-04 22',1),('47_2013-11-04-02',22),('47_2013-11-05',1),('47_2013-11-05 12',1),('47_2013-11-05-02',1),('47_2013-11-06',11),('47_2013-11-06 11',7),('47_2013-11-06 13',2),('47_2013-11-06 15',2),('47_2013-11-06-02',11),('47_2013-11-07',14),('47_2013-11-07 12',2),('47_2013-11-07 13',7),('47_2013-11-07 18',5),('47_2013-11-07-02',14),('47_2013-11-08',81),('47_2013-11-08 15',3),('47_2013-11-08 16',4),('47_2013-11-08 17',36),('47_2013-11-08 18',17),('47_2013-11-08 19',5),('47_2013-11-08 21',2),('47_2013-11-08 22',8),('47_2013-11-08 23',6),('47_2013-11-08-02',81),('47_2013-11-09',67),('47_2013-11-09 00',12),('47_2013-11-09 14',1),('47_2013-11-09 15',2),('47_2013-11-09 16',2),('47_2013-11-09 23',50),('47_2013-11-09-02',67),('47_2013-11-10',73),('47_2013-11-10 10',65),('47_2013-11-10 11',2),('47_2013-11-10 12',1),('47_2013-11-10 14',3),('47_2013-11-10 15',1),('47_2013-11-10 22',1),('47_2013-11-10-03',73),('47_2013-11-11',5),('47_2013-11-11 22',1),('47_2013-11-11 23',4),('47_2013-11-11-03',5),('47_2013-11-12',42),('47_2013-11-12 00',3),('47_2013-11-12 16',5),('47_2013-11-12 17',5),('47_2013-11-12 18',6),('47_2013-11-12 19',7),('47_2013-11-12 23',16),('47_2013-11-12-03',42),('47_2013-11-19',1),('47_2013-11-19 23',1),('47_2013-11-19-04',1),('48_2013-11',7),('48_2013-11-04',3),('48_2013-11-04 00',3),('48_2013-11-04-02',3),('48_2013-11-08',2),('48_2013-11-08 17',2),('48_2013-11-08-02',2),('48_2013-11-18',2),('48_2013-11-18 23',2),('48_2013-11-18-04',2),('49_2013-11',2),('49_2013-11-09',2),('49_2013-11-09 16',2),('49_2013-11-09-02',2),('tuoitre.vn_2013-11',3),('tuoitre.vn_2013-11-13',3),('tuoitre.vn_2013-11-13 00',3),('tuoitre.vn_2013-11-13-03',3),('vietpage_discount_2013-11',99),('vietpage_discount_2013-11-13',2),('vietpage_discount_2013-11-13 23',2),('vietpage_discount_2013-11-13-03',2),('vietpage_discount_2013-11-14',1),('vietpage_discount_2013-11-14 10',1),('vietpage_discount_2013-11-14-03',1),('vietpage_discount_2013-11-15',45),('vietpage_discount_2013-11-15 10',2),('vietpage_discount_2013-11-15 11',3),('vietpage_discount_2013-11-15 23',40),('vietpage_discount_2013-11-15-03',45),('vietpage_discount_2013-11-16',39),('vietpage_discount_2013-11-16 00',38),('vietpage_discount_2013-11-16 01',1),('vietpage_discount_2013-11-16-03',39),('vietpage_discount_2013-11-17',1),('vietpage_discount_2013-11-17 01',1),('vietpage_discount_2013-11-17-04',1),('vietpage_discount_2013-11-19',5),('vietpage_discount_2013-11-19 23',5),('vietpage_discount_2013-11-19-04',5),('vietpage_discount_2013-11-20',6),('vietpage_discount_2013-11-20 00',2),('vietpage_discount_2013-11-20 10',2),('vietpage_discount_2013-11-20 12',2),('vietpage_discount_2013-11-20-04',6),('vietpage_home_2013-11',139),('vietpage_home_2013-11-13',35),('vietpage_home_2013-11-13 00',1),('vietpage_home_2013-11-13 13',13),('vietpage_home_2013-11-13 14',15),('vietpage_home_2013-11-13 16',6),('vietpage_home_2013-11-13-03',35),('vietpage_home_2013-11-14',8),('vietpage_home_2013-11-14 11',3),('vietpage_home_2013-11-14 22',5),('vietpage_home_2013-11-14-03',8),('vietpage_home_2013-11-15',7),('vietpage_home_2013-11-15 10',3),('vietpage_home_2013-11-15 11',2),('vietpage_home_2013-11-15 22',1),('vietpage_home_2013-11-15 23',1),('vietpage_home_2013-11-15-03',7),('vietpage_home_2013-11-16',3),('vietpage_home_2013-11-16 00',2),('vietpage_home_2013-11-16 01',1),('vietpage_home_2013-11-16-03',3),('vietpage_home_2013-11-17',24),('vietpage_home_2013-11-17 00',12),('vietpage_home_2013-11-17 01',12),('vietpage_home_2013-11-17-04',24),('vietpage_home_2013-11-19',39),('vietpage_home_2013-11-19 23',39),('vietpage_home_2013-11-19-04',39),('vietpage_home_2013-11-20',23),('vietpage_home_2013-11-20 00',3),('vietpage_home_2013-11-20 10',3),('vietpage_home_2013-11-20 11',6),('vietpage_home_2013-11-20 12',11),('vietpage_home_2013-11-20-04',23),('vietpage_hotnews_2013-11',106),('vietpage_hotnews_2013-11-13',37),('vietpage_hotnews_2013-11-13 00',1),('vietpage_hotnews_2013-11-13 16',1),('vietpage_hotnews_2013-11-13 17',6),('vietpage_hotnews_2013-11-13 18',1),('vietpage_hotnews_2013-11-13 23',28),('vietpage_hotnews_2013-11-13-03',37),('vietpage_hotnews_2013-11-14',2),('vietpage_hotnews_2013-11-14 10',1),('vietpage_hotnews_2013-11-14 22',1),('vietpage_hotnews_2013-11-14-03',2),('vietpage_hotnews_2013-11-15',27),('vietpage_hotnews_2013-11-15 10',21),('vietpage_hotnews_2013-11-15 11',1),('vietpage_hotnews_2013-11-15 22',1),('vietpage_hotnews_2013-11-15 23',4),('vietpage_hotnews_2013-11-15-03',27),('vietpage_hotnews_2013-11-16',35),('vietpage_hotnews_2013-11-16 00',35),('vietpage_hotnews_2013-11-16-03',35),('vietpage_hotnews_2013-11-17',1),('vietpage_hotnews_2013-11-17 00',1),('vietpage_hotnews_2013-11-17-04',1),('vietpage_hotnews_2013-11-19',1),('vietpage_hotnews_2013-11-19 23',1),('vietpage_hotnews_2013-11-19-04',1),('vietpage_hotnews_2013-11-20',3),('vietpage_hotnews_2013-11-20 00',1),('vietpage_hotnews_2013-11-20 10',1),('vietpage_hotnews_2013-11-20 12',1),('vietpage_hotnews_2013-11-20-04',3),('vietpage_newItems_2013-11',101),('vietpage_newItems_2013-11-13',3),('vietpage_newItems_2013-11-13 23',3),('vietpage_newItems_2013-11-13-03',3),('vietpage_newItems_2013-11-14',21),('vietpage_newItems_2013-11-14 10',21),('vietpage_newItems_2013-11-14-03',21),('vietpage_newItems_2013-11-15',41),('vietpage_newItems_2013-11-15 10',1),('vietpage_newItems_2013-11-15 11',28),('vietpage_newItems_2013-11-15 22',1),('vietpage_newItems_2013-11-15 23',11),('vietpage_newItems_2013-11-15-03',41),('vietpage_newItems_2013-11-16',17),('vietpage_newItems_2013-11-16 00',16),('vietpage_newItems_2013-11-16 01',1),('vietpage_newItems_2013-11-16-03',17),('vietpage_newItems_2013-11-17',3),('vietpage_newItems_2013-11-17 00',2),('vietpage_newItems_2013-11-17 01',1),('vietpage_newItems_2013-11-17-04',3),('vietpage_newItems_2013-11-19',9),('vietpage_newItems_2013-11-19 17',2),('vietpage_newItems_2013-11-19 23',7),('vietpage_newItems_2013-11-19-04',9),('vietpage_newItems_2013-11-20',7),('vietpage_newItems_2013-11-20 00',3),('vietpage_newItems_2013-11-20 10',3),('vietpage_newItems_2013-11-20 12',1),('vietpage_newItems_2013-11-20-04',7),('vietpage_news_2013-11',24),('vietpage_news_2013-11-13',1),('vietpage_news_2013-11-13 23',1),('vietpage_news_2013-11-13-03',1),('vietpage_news_2013-11-15',10),('vietpage_news_2013-11-15 10',2),('vietpage_news_2013-11-15 11',1),('vietpage_news_2013-11-15 23',7),('vietpage_news_2013-11-15-03',10),('vietpage_news_2013-11-16',6),('vietpage_news_2013-11-16 00',5),('vietpage_news_2013-11-16 01',1),('vietpage_news_2013-11-16-03',6),('vietpage_news_2013-11-17',1),('vietpage_news_2013-11-17 01',1),('vietpage_news_2013-11-17-04',1),('vietpage_news_2013-11-19',4),('vietpage_news_2013-11-19 23',4),('vietpage_news_2013-11-19-04',4),('vietpage_news_2013-11-20',2),('vietpage_news_2013-11-20 10',1),('vietpage_news_2013-11-20 12',1),('vietpage_news_2013-11-20-04',2),('vietpage_search_2013-11',12),('vietpage_search_2013-11-14',4),('vietpage_search_2013-11-14 22',2),('vietpage_search_2013-11-14 23',2),('vietpage_search_2013-11-14-03',4),('vietpage_search_2013-11-15',2),('vietpage_search_2013-11-15 10',2),('vietpage_search_2013-11-15-03',2),('vietpage_search_2013-11-16',1),('vietpage_search_2013-11-16 00',1),('vietpage_search_2013-11-16-03',1),('vietpage_search_2013-11-17',1),('vietpage_search_2013-11-17 01',1),('vietpage_search_2013-11-17-04',1),('vietpage_search_2013-11-20',4),('vietpage_search_2013-11-20 00',2),('vietpage_search_2013-11-20 10',2),('vietpage_search_2013-11-20-04',4);
/*!40000 ALTER TABLE `trk_page_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trk_user`
--

DROP TABLE IF EXISTS `trk_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trk_user` (
  `id` varchar(100) NOT NULL,
  `new_user_count` int(10) unsigned NOT NULL,
  `user_login_count` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trk_user`
--

LOCK TABLES `trk_user` WRITE;
/*!40000 ALTER TABLE `trk_user` DISABLE KEYS */;
INSERT INTO `trk_user` VALUES ('2013-01',2,2),('2013-02',2,4),('2013-08',2,8),('2013-09-01',2,2),('2013-09-02',1,1),('2013-09-03',1,1),('2013-09-04',2,3),('2013-09-05',2,5),('2013-09-06',3,90),('2013-09-10',1,6),('2013-09-30',2,3),('2013-10',0,103),('2013-10-01',0,1),('2013-10-02',0,3),('2013-10-04',0,2),('2013-10-05',1,1),('2013-10-06',2,1),('2013-10-07',0,8),('2013-10-07 22',0,7),('2013-10-07 23',0,1),('2013-10-07-02',0,8),('2013-10-08',1,4),('2013-10-09',0,1),('2013-10-09 23',0,1),('2013-10-09-02',0,1),('2013-10-10',0,6),('2013-10-10 09',0,2),('2013-10-10 10',0,3),('2013-10-10 11',0,1),('2013-10-10-02',0,6),('2013-10-14',0,1),('2013-10-14 23',0,1),('2013-10-14-03',0,1),('2013-10-16',0,3),('2013-10-16 00',0,3),('2013-10-16-03',0,3),('2013-10-17',0,19),('2013-10-17 18',0,4),('2013-10-17 22',0,5),('2013-10-17 23',0,10),('2013-10-17-03',0,19),('2013-10-18',0,15),('2013-10-18 11',0,1),('2013-10-18 14',0,2),('2013-10-18 15',0,2),('2013-10-18 16',0,7),('2013-10-18 17',0,1),('2013-10-18 23',0,2),('2013-10-18-03',0,15),('2013-10-19',0,14),('2013-10-19 15',0,2),('2013-10-19 16',0,3),('2013-10-19 22',0,5),('2013-10-19 23',0,4),('2013-10-19-03',0,14),('2013-10-20',0,2),('2013-10-20 00',0,2),('2013-10-20-04',0,2),('2013-10-22',0,9),('2013-10-22 14',0,6),('2013-10-22 15',0,1),('2013-10-22 17',0,1),('2013-10-22 18',0,1),('2013-10-22-04',0,9),('2013-10-23',0,5),('2013-10-23 14',0,1),('2013-10-23 16',0,2),('2013-10-23 17',0,1),('2013-10-23 18',0,1),('2013-10-23-04',0,5),('2013-10-24',0,8),('2013-10-24 11',0,1),('2013-10-24 13',0,1),('2013-10-24 15',0,1),('2013-10-24 16',0,1),('2013-10-24 17',0,2),('2013-10-24 23',0,2),('2013-10-24-04',0,8),('2013-10-25',0,2),('2013-10-25 18',0,2),('2013-10-25-04',0,2),('2013-10-26',0,5),('2013-10-26 20',0,1),('2013-10-26 21',0,1),('2013-10-26 22',0,3),('2013-10-26-04',0,5),('2013-10-28',0,1),('2013-10-28 23',0,1),('2013-10-28-05',0,1),('2013-10-29',0,1),('2013-10-29 18',0,1),('2013-10-29-05',0,1),('2013-10-31',0,3),('2013-10-31 16',0,2),('2013-10-31 22',0,1),('2013-10-31-05',0,3),('2013-11',2,129),('2013-11-01',0,2),('2013-11-01 00',0,1),('2013-11-01 23',0,1),('2013-11-01-01',0,2),('2013-11-02',0,4),('2013-11-02 12',0,4),('2013-11-02-01',0,4),('2013-11-03',0,11),('2013-11-03 11',0,2),('2013-11-03 16',0,1),('2013-11-03 17',0,6),('2013-11-03 18',0,1),('2013-11-03 22',0,1),('2013-11-03-02',0,11),('2013-11-04',1,15),('2013-11-04 00',1,5),('2013-11-04 17',0,1),('2013-11-04 18',0,8),('2013-11-04 19',0,1),('2013-11-04-02',1,15),('2013-11-05',0,1),('2013-11-05 00',0,1),('2013-11-05-02',0,1),('2013-11-06',0,14),('2013-11-06 13',0,1),('2013-11-06 15',0,5),('2013-11-06 16',0,1),('2013-11-06 17',0,7),('2013-11-06-02',0,14),('2013-11-07',0,20),('2013-11-07 10',0,1),('2013-11-07 13',0,1),('2013-11-07 14',0,9),('2013-11-07 17',0,3),('2013-11-07 18',0,2),('2013-11-07 22',0,3),('2013-11-07 23',0,1),('2013-11-07-02',0,20),('2013-11-08',0,6),('2013-11-08 18',0,1),('2013-11-08 22',0,5),('2013-11-08-02',0,6),('2013-11-09',1,22),('2013-11-09 15',0,12),('2013-11-09 16',1,10),('2013-11-09-02',1,22),('2013-11-10',0,18),('2013-11-10 11',0,5),('2013-11-10 12',0,2),('2013-11-10 15',0,3),('2013-11-10 16',0,1),('2013-11-10 22',0,2),('2013-11-10 23',0,5),('2013-11-10-03',0,18),('2013-11-11',0,3),('2013-11-11 22',0,3),('2013-11-11-03',0,3),('2013-11-12',0,2),('2013-11-12 19',0,2),('2013-11-12-03',0,2),('2013-11-13',0,3),('2013-11-13 00',0,3),('2013-11-13-03',0,3),('2013-11-14',0,1),('2013-11-14 10',0,1),('2013-11-14-03',0,1),('2013-11-16',0,2),('2013-11-16 00',0,1),('2013-11-16 01',0,1),('2013-11-16-03',0,2),('2013-11-18',0,2),('2013-11-18 23',0,2),('2013-11-18-04',0,2),('2013-11-19',0,2),('2013-11-19 23',0,2),('2013-11-19-04',0,2),('2013-11-20',0,1),('2013-11-20 00',0,1),('2013-11-20-04',0,1);
/*!40000 ALTER TABLE `trk_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(45) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (15,'admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','admin'),(16,'tmk','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(17,'tmk1','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(18,'tmkff','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(19,'langnuongnambo','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(20,'hoangty','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(21,'namson','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(22,'rookwaterbay','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user'),(23,'tmk5','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-20 13:22:46
