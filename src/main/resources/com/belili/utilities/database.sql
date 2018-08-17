CREATE DATABASE MBR_WAREHOUSE;
USE MBR_WAREHOUSE;

CREATE TABLE Administrator(
  `id_administrator` INT NOT NULL,
  `image_administrator` LONGBLOB NULL,
  `username_administrator` VARCHAR(100) NOT NULL,
  `password_administrator` VARCHAR(100) NOT NULL,
  `fullname_administrator` VARCHAR(100) NOT NULL,
  `correo_administrator` VARCHAR(100) NULL,
  `phone_administrator` VARCHAR(20) NULL,
  	PRIMARY KEY (`id_administrator`))
	ENGINE = InnoDB;
                 
CREATE TABLE User(
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `image_user` LONGBLOB NULL,
  `code_user` VARCHAR(20) NOT NULL,
  `password_user` VARCHAR(100) NOT NULL,
  `fullname_user` VARCHAR(100) NOT NULL,
  `correo_user` VARCHAR(100) NULL,
  `phone1_user` VARCHAR(20) NULL,
  `phone2_user` VARCHAR(20) NULL,
  `date_user` DATE default NULL,
  `state_user` TINYINT(1) NOT NULL,
  `permissionMaintenance_user` TINYINT(1) NOT NULL,
  `permissionPurchase_user` TINYINT(1) NOT NULL,
  `permissionSale_user` TINYINT(1) NOT NULL,
  `permissionWarehouse_user` TINYINT(1) NOT NULL,
  	PRIMARY KEY (`id_user`))
	ENGINE = InnoDB;

CREATE TABLE Customer(
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `code_customer` VARCHAR(20) NOT NULL,
  `name_customer` VARCHAR(50) NOT NULL,
  `lastname_customer` VARCHAR(100) NOT NULL,
  `dni_customer` VARCHAR(20) NOT NULL,
  `address_customer` VARCHAR(100) NULL,
  `correo_customer` VARCHAR(100) NULL,
  `phone1_customer` VARCHAR(20) NULL,
  `phone2_customer` VARCHAR(20) NULL,
  `state_customer` TINYINT(1) NOT NULL,
  `date_customer` DATE default NULL,
  `id_user` INT NOT NULL,
  	PRIMARY KEY (`id_customer`),
        FOREIGN KEY (`id_user`) REFERENCES User (`id_user`))
	ENGINE = InnoDB;
                 
CREATE TABLE Provider(
  `id_provider` INT NOT NULL AUTO_INCREMENT,
  `code_provider` VARCHAR(20) NOT NULL,
  `business_provider` VARCHAR(150) NOT NULL,
  `ruc_provider` VARCHAR(20) NOT NULL,
  `address_provider` VARCHAR(60) NULL,
  `contact_provider` VARCHAR(60) NULL,
  `correo_provider` VARCHAR(100) NULL,
  `phone1_provider` VARCHAR(20) NULL,
  `phone2_provider` VARCHAR(20) NULL,
  `state_provider` TINYINT(1) NOT NULL,
  `date_provider` DATE default NULL,
  `id_user` INT NOT NULL,
  	PRIMARY KEY (`id_provider`),
        FOREIGN KEY (`id_user`) REFERENCES User (`id_user`))
	ENGINE = InnoDB;

CREATE TABLE Warehouse(
  `id_warehouse` INT NOT NULL AUTO_INCREMENT,
  `code_warehouse` VARCHAR(20) NOT NULL,
  `name_warehouse` VARCHAR(100) NOT NULL,
  `address_warehouse` VARCHAR(150) NOT NULL,
  `phone1_warehouse` VARCHAR(20) NULL,
  `phone2_warehouse` VARCHAR(20) NULL,
  `id_user` INT NOT NULL,
  	PRIMARY KEY (`id_warehouse`),
        FOREIGN KEY (`id_user`) REFERENCES User (`id_user`))
	ENGINE = InnoDB;

CREATE TABLE Product(
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `family_product` VARCHAR(150) NOT NULL,
  `brand_product` VARCHAR(150) NOT NULL,
  `model_product` VARCHAR(100) NOT NULL,
  `type_product` VARCHAR(100) NOT NULL,
  `id_user` INT NOT NULL,
  `id_warehouse` INT NOT NULL,
  	PRIMARY KEY (`id_product`),
        FOREIGN KEY (`id_user`) REFERENCES User (`id_user`),
        FOREIGN KEY (`id_warehouse`) REFERENCES Warehouse (`id_warehouse`))
	ENGINE = InnoDB;

delimiter $
CREATE PROCEDURE Register_User(IN iimage_user LONGBLOB, IN ppassword_user varchar(100) , IN ffullname_user varchar(100) ,
IN ccorreo_user varchar(100) , IN pphone1_user varchar(20), IN pphone2_user varchar(20), IN ddate_user DATE , 
IN sstate_user TINYINT(1), IN ppermissionMaintenance_user TINYINT(1), IN ppermissionPurchase_user TINYINT(1),
IN ppermissionSale_user TINYINT(1), IN ppermissionWarehouse_user TINYINT(1))
begin
	declare maximo varchar(10);
	declare num int;
	declare codigo varchar(10);
	
	SET maximo = (SELECT MAX(code_user) FROM User);
	SET num = (SELECT LTRIM(RIGHT(maximo,3)));
	
        IF num>=1 and num<=8 then
		set num=num+1;
		set codigo=(select concat('MBR00', CAST(num AS CHAR)));
	ELSEIF num>=9 and num<=98 then
		set num=num+1;
		set codigo = (select concat('MBR0', CAST(num AS CHAR)));
	ELSEIF num>=98 and num<=998 then
		set num=num+1;
		set codigo = (select concat('MBR', CAST(num AS CHAR)));
	ELSE
		set codigo=(select 'MBR001');
	END IF;
	
	INSERT INTO User (image_user,code_user,password_user,fullname_user,correo_user,phone_user,date_user,state_user,
                            permissionMaintenance_user,permissionPurchase_user,permissionSale_user,permissionWarehouse_user) 
                    values (iimage_user,codigo,ppassword_user,ffullname_user,ccorreo_user,pphone_user,ddate_user,sstate_user,
                            ppermissionMaintenance_user,ppermissionPurchase_user,ppermissionSale_user,ppermissionWarehouse_user);
end $
                                            
delimiter $
CREATE PROCEDURE Register_Customer(IN nname_customer varchar(100), IN llastname_customer varchar(100), IN ddni_customer VARCHAR(20) ,
                                    IN aaddress_customer varchar(100), IN ccorreo_customer varchar(100), IN pphone1_customer varchar(20),
                                     IN pphone2_customer varchar(20), IN sstate_customer TINYINT(1) , IN ddate_customer DATE , IN iid_user int)
begin
	declare maximo varchar(10);
	declare num int;
	declare codigo varchar(10);
	
	SET maximo = (SELECT MAX(code_customer) FROM Customer);
	SET num = (SELECT LTRIM(RIGHT(maximo,8)));
	
	IF num>=1 and num<=8 then
		set num=num+1;
		set codigo=(select concat('CLI-00', CAST(num AS CHAR)));
	ELSEIF num>=9 and num<=98 then
		set num=num+1;
		set codigo = (select concat('CLI-0', CAST(num AS CHAR)));
	ELSEIF num>=98 and num<=998 then
		set num=num+1;
		set codigo = (select concat('CLI-', CAST(num AS CHAR)));
	ELSE
		set codigo=(select 'CLI-001');
	END IF;
	
	INSERT INTO Customer (code_customer , name_customer , lastname_customer , dni_customer , address_customer , correo_customer,
                                phone1_customer , phone2_customer , state_customer , date_customer , id_user) 
                            values (codigo , nname_customer , llastname_customer , ddni_customer , aaddress_customer , ccorreo_customer,
                                    pphone1_customer , pphone2_customer , sstate_customer , ddate_customer, iid_user);
end $

delimiter $
CREATE PROCEDURE Register_Provider(IN bbusiness_provider varchar(150) , IN rruc_provider varchar(20) , IN aaddress_provider varchar(60) ,
                                    IN ccontact_provider varchar(60) , IN ccorreo_provider varchar(100) , IN pphone1_provider varchar(20) , 
                                    IN pphone2_provider varchar(20) , IN sstate_provider TINYINT(1) , IN ddate_provider DATE , IN iid_user int)

begin
	declare maximo varchar(10);
	declare num int;
	declare codigo varchar(10);
	
	SET maximo = (SELECT MAX(code_user) FROM Provider);
	SET num = (SELECT LTRIM(RIGHT(maximo,3)));
	
	IF num>=1 and num<=8 then
		set num=num+1;
		set codigo=(select concat('PRO-00', CAST(num AS CHAR)));
	ELSEIF num>=9 and num<=98 then
		set num=num+1;
		set codigo = (select concat('PRO-0', CAST(num AS CHAR)));
	ELSEIF num>=98 and num<=998 then
		set num=num+1;
		set codigo = (select concat('PRO-', CAST(num AS CHAR)));
	ELSE
		set codigo=(select 'PRO-001');
	END IF;
	
	INSERT INTO Provider (code_provider , business_provider , ruc_provider , address_provider , contact_provider , correo_provider ,
                                phone1_provider , phone2_provider , state_provider,date_provider , id_user) 
                                values (codigo , bbusiness_provider , rruc_provider , aaddress_provider , ccontact_provider , ccorreo_provider ,
                                pphone1_provider , pphone2_provider , sstate_provider,ddate_provider,iid_user);
end $

 `id_warehouse` INT NOT NULL AUTO_INCREMENT,
  `code_warehouse` VARCHAR(20) NOT NULL,
  `name_warehouse` VARCHAR(100) NOT NULL,
  `address_warehouse` VARCHAR(150) NOT NULL,
  `phone1_warehouse` VARCHAR(20) NULL,
  `phone2_warehouse` VARCHAR(20) NULL,
  `id_user` INT NOT NULL,

delimiter $
CREATE PROCEDURE Register_Warehouse(IN nname_warehouse varchar(100) , IN aaddress_warehouse varchar(150) , IN pphone1_warehouse varchar(20) ,
                                    IN pphone2_warehouse varchar(20) , IN iid_user int)

begin
	declare maximo varchar(10);
	declare num int;
	declare codigo varchar(10);
	
	SET maximo = (SELECT MAX(code_user) FROM Warehouse);
	SET num = (SELECT LTRIM(RIGHT(maximo,3)));
	
	IF num>=1 and num<=8 then
		set num=num+1;
		set codigo=(select concat('ALM-00', CAST(num AS CHAR)));
	ELSEIF num>=9 and num<=98 then
		set num=num+1;
		set codigo = (select concat('ALM-0', CAST(num AS CHAR)));
	ELSEIF num>=98 and num<=998 then
		set num=num+1;
		set codigo = (select concat('ALM-', CAST(num AS CHAR)));
	ELSE
		set codigo=(select 'ALM-001');
	END IF;
	
	INSERT INTO Provider (code_warehouse , name_warehouse , address_warehouse , phone1_warehouse , phone2_warehouse , id_user) 
                                values (codigo , nname_warehouse , aaddress_warehouse , aaddress_provider , pphone1_warehouse ,
                                    pphone2_warehouse ,iid_user );
end $


