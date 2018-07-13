CREATE DATABASE ALMACEN;
USE ALMACEN;

CREATE TABLE USERS(
	
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `code_user` VARCHAR(20) NOT NULL,
  `type_user` VARCHAR(100) NOT NULL,
  `image_user` LONGBLOB NULL,
  `username_user` VARCHAR(100) NOT NULL,
  `password_user` VARCHAR(100) NOT NULL,
  `fullname_user` VARCHAR(100) NOT NULL,
  `correo_user` VARCHAR(100) NOT NULL,
  `phone_user` VARCHAR(20) NOT NULL,
  	PRIMARY KEY (`id_user`))
	ENGINE = InnoDB;

delimiter $
CREATE PROCEDURE REGISTRAR_USUARIO(IN ttype_user varchar(100), IN iimg_user LONGBLOB, IN uusername_user varchar(100) , IN ppassword_user varchar(100) , IN ffullname_user varchar(100) , IN ccorreo_user varchar(100) , IN pphone_user varchar(20) )
begin
	declare maximo varchar(10);
	declare num int;
	declare codigo varchar(10);
	
	SET maximo = (SELECT MAX(code_user) FROM USERS);
	SET num = (SELECT LTRIM(RIGHT(maximo,3)));
	
	IF num>=1 and num<=8 then
		set num=num+1;
		set codigo=(select concat('MBR000', CAST(num AS CHAR)));
	ELSEIF num>=9 and num<=98 then
		set num=num+1;
		set codigo = (select concat('MBR00', CAST(num AS CHAR)));
	ELSEIF num>=98 and num<=998 then
		set num=num+1;
		set codigo = (select concat('MBR0', CAST(num AS CHAR)));
  ELSEIF num>=998 and num<=9998 then
		set num=num+1;
		set codigo = (select concat('MBR', CAST(num AS CHAR)));
	ELSE
		set codigo=(select 'MBR0001');
	END IF;
	
	INSERT INTO USERS (code_user,type_user,img_user,username_user,password_user,fullname_user,correo_user,phone_user) values (codigo,ttype_user,iimg_user,uusername_user,ppassword_user,ffullname_user,ccorreo_user,pphone_user);
end $
