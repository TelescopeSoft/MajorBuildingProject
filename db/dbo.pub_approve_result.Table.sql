USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_approve_guide]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_approve_result](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prj_code] [varchar](64) NULL,
	[prj_name] [varchar](200) NULL,
	[prj_num] [varchar](64) NULL,
	[approve_dept_code] [varchar](20) NULL,
	[approve_dept] [varchar](100) NULL,
	[approve_item_label] [varchar](200) NULL,
	[approve_item_code] [varchar](20) NULL,
	[approve_subitem_label] [varchar](200) NULL,
	[approve_subitem_code] [varchar](20) NULL,
	[approve_result] [varchar](200) NULL,
	[approve_num] [varchar](200) NULL,
	[approve_date] datetime NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL,
	) 

GO
SET ANSI_PADDING OFF

