USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_project]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_project](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prj_code] [varchar](64) NULL,
	[major_flag] [char](1) NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL,
	) 
SET ANSI_PADDING OFF

