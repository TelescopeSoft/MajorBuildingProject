USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[profile_project_condition]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[profile_project_condition](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[field] [varchar](100) NULL,
	[type] [varchar](50) NULL,
	[value] [varchar](50) NULL
	) 
	
GO
SET ANSI_PADDING OFF

