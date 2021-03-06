USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_admin_penalty]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_admin_penalty](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[admin_relative_person] [varchar](100) NULL,
	[letter_of_decision] [varchar](64) NULL,
	[name] [varchar](255) NULL,
	[punishment_decision_date] datetime NULL,
	[punish_dept_label] [varchar](64) NULL,
	[punish_category] [varchar](64) NULL,
	[punish_reason] [varchar](255) NULL,
	[punish_basis] [varchar](255) NULL,
	[admin_relative_person_code] [varchar](100) NULL,
	[legal_representative] [varchar](100) NULL,
	[punish_result] [varchar](255) NULL,
	[county] [varchar](20) NULL,
	[public_deadline] datetime NULL,
	[create_by] [varchar](32) NULL,
	[update_by] [varchar](32) NULL,
	[create_date] datetime NULL,
	[update_date] datetime NULL,
	[display_flag] [char](1) NULL,
	[del_flag] [char](1) NULL,
	[prj_num] [varchar](20) null
	) 

GO
SET ANSI_PADDING OFF

