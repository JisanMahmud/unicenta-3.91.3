--    uniCenta oPOS - Touch Friendly Point Of Sale
--    Copyright (C) 2009-2015 uniCenta
--    http://www.unicenta.net
--
--    This file is part of uniCenta oPOS.
--
--    uniCenta oPOS is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    uniCenta oPOS is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

-- Database updater
-- JDL 

-- Add new table
CREATE TABLE APPJL (
    ID VARCHAR(255) NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    VERSION VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);


-- Add new resource file
INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('56', 'Printer.TicketClose', 0, $FILE{/com/openbravo/pos/templates/Printer.TicketClose.xml});

-- PRODUCT
ALTER TABLE PRODUCTS ADD COLUMN ISVPRICE BOOLEAN DEFAULT FALSE NOT NULL;
ALTER TABLE PRODUCTS ADD COLUMN ISVERPATRIB BOOLEAN DEFAULT FALSE NOT NULL;
ALTER TABLE PRODUCTS ADD COLUMN TEXTTIP VARCHAR(255) DEFAULT '';
ALTER TABLE PRODUCTS ADD COLUMN WARRANTY BOOLEAN DEFAULT FALSE NOT NULL;
ALTER TABLE CATEGORIES ADD COLUMN TEXTTIP VARCHAR(255) DEFAULT '';
ALTER TABLE CATEGORIES ADD COLUMN TEXTTIP BOOLEAN DEFAULT TRUE NOT NULL;
ALTER TABLE PLACES ADD COLUMN CUSTOMER VARCHAR(255);
ALTER TABLE PLACES ADD COLUMN WAITER VARCHAR(255);
ALTER TABLE PLACES ADD COLUMN TICKETID VARCHAR(255);
ALTER TABLE PLACES ADD COLUMN TABLEMOVED BOOLEAN DEFAULT FALSE NOT NULL;
ALTER TABLE SHAREDTICKETS ADD COLUMN PICKUPID INTEGER DEFAULT 0 NOT NULL;
ALTER TABLE STOCKDIARY ADD COLUMN AppUser VARCHAR(255);

CREATE TABLE MOORERS (
  VESSELNAME VARCHAR(255),
  SIZE INTEGER,
  DAYS INTEGER,
  POWER BOOLEAN NOT NULL DEFAULT FALSE
  );


CREATE TABLE CSVIMPORT (
  ID VARCHAR(255) NOT NULL,
  ROWNUMBER VARCHAR(255),
  CSVERROR VARCHAR(255),
  REFERENCE VARCHAR(255),
  CODE VARCHAR(255),
  NAME VARCHAR(255),
  PRICEBUY DOUBLE,
  PRICESELL DOUBLE,
  PREVIOUSBUY DOUBLE,
  PREVIOUSSELL DOUBLE,
  PRIMARY KEY (ID)
);

CREATE SEQUENCE PICKUP_NUMBER START WITH 1;


INSERT INTO APPJL (ID, NAME, VERSION) VALUES($APP_ID{}, $APP_NAME{}, $APP_VERSION{});