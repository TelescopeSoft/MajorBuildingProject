USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_config]    Script Date: 2018/8/18 9:10:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_config](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ckey] [varchar](50) NULL,
	[cvalue] [varchar](50) NULL,
 CONSTRAINT [PK_pub_config] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
