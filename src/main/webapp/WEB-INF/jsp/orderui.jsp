<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<body>
		<h1>Test Merchant of CBLPG</h1>
		<h2>Create Order Operation</h2>
		
		<form method="post" action="${pageContext.request.contextPath}/orderui">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td><p>id :</p></td>
					<td><input type="number" size="25" name="id" value=2010/></td>
				</tr>
				<tr>
					<td><p>Merchant :</p></td>
					<td><input type="number" size="25" name="merchant" value=11122/></td>
				</tr>
				
				<tr>
					<td><p>purchaseAmount :</p></td>
					<td><input type="number" size="25" name="purchaseAmount" value=050/></td>
				</tr>
				<tr>
					<td><p>Currency :</p></td>
					<td><input type="text" size="25" name="currency" value="050"/></td>
				</tr>
				<tr>
					<td><p>Description :</p></td>
					<td><input type="text" size="25" name="description" value="Test Product"/></td>
				</tr>
				<tr>
					<td><p>ApproveURL :</p></td>
					<td><input type="text" size="50" name="approveURL" value="http://localhost/cbp/Approved.php" readonly/></td>
				</tr>
				<tr>
					<td><p>CancelURL :</p></td>
					<td><input type="text" size="50" name="cancelURL" value="http://localhost/cbp/Cancelled.php" readonly/></td>
				</tr>
				<tr>
					<td><p>DeclineURL :</p></td>
					<td><input type="text" size="50" name="declineURL" value="http://localhost/cbp/Declined.php" readonly/></td>
				</tr>
			</table>	
				
			<br/>
			<input type="submit" value="Create Order"/>
		</form>
		<hr/>
	</body>
</html>

