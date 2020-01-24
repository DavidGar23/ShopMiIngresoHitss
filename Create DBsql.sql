CREATE DATABASE [DBMiIngresoHitss]

USE [DBMiIngresoHitss]
GO

/****** Object:  Table [dbo].[tbl_client]    Script Date: 24/01/2020 11:09:56 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[tbl_client](
	[id_client] [bigint] NOT NULL,
	[name_client] [nvarchar](500) NOT NULL,
	[identification_client] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_client] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO





USE [DBMiIngresoHitss]
GO

/****** Object:  Table [dbo].[tbl_product]    Script Date: 24/01/2020 11:09:36 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[tbl_product](
	[id_product] [bigint] NOT NULL,
	[name_product] [nvarchar](500) NOT NULL,
	[price_product] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_product] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO




USE [DBMiIngresoHitss]
GO

/****** Object:  Table [dbo].[tbl_purchase]    Script Date: 24/01/2020 10:25:56 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[tbl_purchase](
	[id_purchase] [bigint] NOT NULL,
	[id_client] [bigint] NULL,
	[id_product] [bigint] NULL,
	[date_purchase] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_purchase] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tbl_purchase]  WITH CHECK ADD FOREIGN KEY([id_client])
REFERENCES [dbo].[tbl_client] ([id_client])
GO

ALTER TABLE [dbo].[tbl_purchase]  WITH CHECK ADD FOREIGN KEY([id_product])
REFERENCES [dbo].[tbl_product] ([id_product])
GO




USE [DBMiIngresoHitss]
GO

/****** Object:  View [dbo].[v_Purchase]    Script Date: 24/01/2020 10:34:14 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE view [dbo].[v_Purchase] as

select 
	'1' as id_v_Purchase,p.id_purchase,p.date_purchase,c.name_client,c.identification_client,pr.name_product,pr.price_product
from tbl_purchase p
inner join tbl_client c on p.id_client = c.id_client
inner join tbl_product pr on p.id_product = pr.id_product
GO


