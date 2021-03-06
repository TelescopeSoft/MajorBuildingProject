USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_expropriation]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_expropriation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prj_code] [varchar](64) NULL,
	[prj_name] [varchar](200) NULL,
	[county_num] [varchar](20) NULL,
	[approve_dept] [varchar](100) NULL,
	[address] [varchar](200) NULL,
	[town] [varchar](200) NULL,
	[village] [varchar](200) NULL,
	[approve_num] [varchar](200) NULL,
	[approve_date] datetime NULL,
	[lcid] [varchar](64) NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL
	) 
	
CREATE TABLE [dbo].[pub_expropriation_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prj_code] [varchar](64) NULL,
	[prj_name] [varchar](200) NULL,
	[approve_num] [varchar](200) NULL,
	[approve_date] datetime NULL,
	[address] [varchar](200) NULL,
	[county_num] [varchar](20) NULL,
	[lcid] [varchar](64) NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL
	) 

CREATE TABLE [dbo].[pub_expropriation_detail_info](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[lcid] [varchar](64) NULL,
	[info_type] [varchar](20) NULL,
	[content] [varchar](100) NULL,
	[sort] [int] NULL,
	[title] [varchar](100) NULL,
	[public_unit] [varchar](100) NULL,
	[public_date] datetime NULL,
	[file_name] varchar(100) NULL,
	[file_preffix] varchar(100) NULL,
	[file_url] varchar(255) NULL,
	[file_path] varchar(255) NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL
	) 
	
GO
SET ANSI_PADDING OFF

