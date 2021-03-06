USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_environment_protection]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_environment_protection](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prj_code] [varchar](64) NULL,
	[close_flag] bit NULL,
	[wash_flag] bit NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL,
	) 
CREATE TABLE [dbo].[pub_environment_protection_rectify](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[environment_protection_id] [int] NULL,
	[prj_code] [varchar](64) NULL,
	[rectify] [varchar](255) NULL,
	[rectify_notice] [varchar](255) NULL,
	) 

GO
SET ANSI_PADDING OFF

