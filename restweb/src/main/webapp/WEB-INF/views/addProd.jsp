<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>AddProduct</title>
</head>
	<title>AddProduct</title> 
	
	 <script type='text/javascript'> 
	  function valida() { 
	  if (document.f.nom.value=='')
	    { document.f.errname.value='camp name buit'; 
	    } else  document.f.errname.value=''; 
	  if (document.f.description.value=='') 
	  { document.f.errdesc.value='camp description buit'; 
	  } else document.f.errdesc.value=''; 
	  if (document.f.price.value=='')  
	    { document.f.errprice.value='camp price buit'; 
	    } else document.f.errprice.value=''; 
	 if (f.nom.value!='' && f.description.value!='' && f.price.value!='') 
	  { 
	   f.action='addProduct'; 
	    f.valor.value=2 
	   f.submit(); 
	  } 
	 return false; 
	} 
	</script> 
	</head> 
	<body> 
	 <form name='f' action='' method='post' onsubmit='return valida()' > 
	Name <input type='text' name='nom'/> <input type='text' name='errname'/> 
	<br>Desc<input type='text' name='description'> <input type='text' name='errdesc'/> 
	<br>Price<input type='text' name='price'/> <input type='text' name='errprice'/> 
	<br><input type='hidden' name='valor' value='1'/> 
	<br><input type='submit' name='mybutton' /> 
	<br></form> 
	</body> 
	</html>