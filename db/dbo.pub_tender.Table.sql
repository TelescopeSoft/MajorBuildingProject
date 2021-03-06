USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_expropriation]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_trade](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prj_code] [varchar](64) NULL,
	[prj_name] [varchar](200) NULL,
	[tender_inner_num] [varchar](200) NULL,
	[tender_type] [varchar](100) NULL,
	[title] [varchar](200) NULL,
	[writeTime] datetime NULL,
	[openTime] datetime NULL,
	[indexId] [varchar](64) NULL,
	[url] [varchar](200) NULL,
	[organization] [varchar](100) NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL
	) 
	
CREATE TABLE [dbo].[pub_trade_content](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[indexId] [varchar](64) NULL,
	[content] [nvarchar](max) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[del_flag] [char](1) NULL
	) 
 
	
GO
SET ANSI_PADDING OFF

