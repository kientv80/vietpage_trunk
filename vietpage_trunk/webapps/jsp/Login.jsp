<div align="center">
<form action="login" method="post" id="login">
<table>
	<tr>
		<td><label>Username </label></td><td><input type="text" name="username"/> </td>
	</tr>
	<tr>
		<td><label>Password </label></td><td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td><button type="submit" value="Login">Login</button></td><td></td>
	</tr>
</table>
<input type="hidden" value="login" name="action">
</form>
	<script type="text/javascript">
		function login(){
			document.getElementById('login').submit();
		}
	</script>
</div>