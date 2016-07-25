CREATE TABLE `insurance` (
  `HealthInsuranceID` int(11) DEFAULT NULL,
  `HealthInsuranceType` text,
  `HealthInsuranceName` text,
  `PriceGroupID` int(11) DEFAULT NULL,
  `IKNumber` int(11) DEFAULT NULL,
  `VKNumber` text,
  `ShortNumber` text,
  `ValidFrom` text,
  `ValidTo` text,
  `Deductible` text,
  `Street` text,
  `City` text,
  `POBox` text,
  `Phone` text,
  `Fax` text,
  `Email` text,
  `Www` text,
  `Remark` text,
  `InsurancePayerID` text,
  `SelfCreated` text,
  `Version` int(11) DEFAULT NULL,
  `Deleted` int(11) DEFAULT NULL,
  `ZIPID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `patient` (
  `PatientID` int(11) DEFAULT NULL,
  `InternalNumber` int(11) DEFAULT NULL,
  `PatientType` text,
  `Sex` text,
  `PoliteAddress` text,
  `LetterPoliteAddress` text,
  `LastNamePrefix` text,
  `Title` text,
  `FirstName` text,
  `LastName` text,
  `DateOfBirth` text,
  `Street` text,
  `CountryCode` text,
  `ZIPID` int(11) DEFAULT NULL,
  `City` text,
  `HomePhone` text,
  `WorkPhone` text,
  `MobilePhone` text,
  `Fax` text,
  `Email` text,
  `WWW` text,
  `StaffID` text,
  `DoctorID` int(11) DEFAULT NULL,
  `HealthInsuranceID` int(11) DEFAULT NULL,
  `HealthInsuranceAccount` text,
  `HealthInsuranceStatus` text,
  `StatusExtension` text,
  `CardValidTo` text,
  `SurchargeStatus` text,
  `Homepatient` text,
  `Distance` int(11) DEFAULT NULL,
  `HandlingType` text,
  `AltPayeeActive` text,
  `APPoliteAddress` text,
  `APLetterPoliteAddress` text,
  `APLastNamePrefix` text,
  `APTitle` text,
  `APLastName` text,
  `APFirstName` text,
  `APStreet` text,
  `APZIP` text,
  `APCity` text,
  `Profession` text,
  `Company` text,
  `BankID` text,
  `BankName` text,
  `BankAccount` text,
  `Active` text,
  `RecordCreationDate` text,
  `RecordModificationDate` text,
  `Remark` text,
  `Version` int(11) DEFAULT NULL,
  `Deleted` int(11) DEFAULT NULL,
  `ExtPatientID` text,
  `IBAN` text,
  `BIC` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `zip` (
  `ZIPID` int(11) NOT NULL,
  `ZIP` text,
  `City` text,
  `LandID` int(11) DEFAULT NULL,
  `SelfCreated` text,
  `Version` int(11) DEFAULT NULL,
  `Deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`ZIPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



