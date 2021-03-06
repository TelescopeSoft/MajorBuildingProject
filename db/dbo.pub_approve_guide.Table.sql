USE [MajorProjectLib]
GO
/****** Object:  Table [dbo].[pub_approve_guide]    Script Date: 2018/7/12 15:37:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pub_approve_guide](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[office_id] [varchar](64) NULL,
	[approve_item_label] [varchar](200) NULL,
	[approve_item_code] [varchar](20) NULL,
	[approve_guide_url] [varchar](200) NULL,
	[approve_app_url] [varchar](200) NULL,
 CONSTRAINT [PK_pub_approve_guide] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[pub_approve_guide] ON 

INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (1, N'9cea75a606fe4577bc0ba2eab55f51de', N'企业、事业单位、社会团体等投资建设的固定资产投资项目核准', N'FGJ001', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=88e0ac194043496f9c49945508e883fc&amp;ql_kind=01&amp;iddept_ql_inf=d2719b9afd934a88b1fc706c7a6a49dc', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (2, N'9cea75a606fe4577bc0ba2eab55f51de', N'企业投资建设固定资产投资项目备案', N'FGJ002', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=5db4e6e93db341bc8545c45617c4c649&amp;ql_kind=10&amp;iddept_ql_inf=83a9ed81303243d39fed2d94a1c3c6a5', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (3, N'9cea75a606fe4577bc0ba2eab55f51de', N'固定资产投资项目节能评估和审查', N'FGJ003', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=7f21c2e3011a40f48f1acd43f6bf2233&amp;ql_kind=01&amp;iddept_ql_inf=14888cd940f7408492702290133b25c4', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (4, N'9cea75a606fe4577bc0ba2eab55f51de', N'政府投资项目审批', N'FGJ004', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=88e0ac194043496f9c49945508e883fc&amp;ql_kind=01&amp;iddept_ql_inf=d2719b9afd934a88b1fc706c7a6a49dc', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (5, N'ee7dd4611cd04bb59948d0983122374e', N'无锡市国土资源局滨湖分局', N'GT001', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (6, N'ee7dd4611cd04bb59948d0983122374e', N'无锡市国土资源局滨湖分局', N'GT002', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (7, N'45b245ce6a2b4f17941b1d97d0b40585', N'建筑工程施工许可证的发放', N'ZJ001', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=04b0865faa5c4087af967731fda23733&amp;ql_kind=01&amp;iddept_ql_inf=ab33db75969b46dfb3423aeee8ff1d7e', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (8, N'45b245ce6a2b4f17941b1d97d0b40585', N'房屋建筑和市政基础设施工程竣工验收的备案', N'ZJ002', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=3bffed7a39bb4c66ab2732c2773d01c9&amp;ql_kind=10&amp;iddept_ql_inf=af92d965b6a34d2ca440d43211b09af7', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (9, N'83af32be68924112b8419b5fc0b18413', N'核发选址意见书', N'GH001', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (10, N'83af32be68924112b8419b5fc0b18413', N'建设工程设计方案审查', N'GH002', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (11, N'83af32be68924112b8419b5fc0b18413', N'核发建设用地规划许可证', N'GH003', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (12, N'83af32be68924112b8419b5fc0b18413', N'核发建设工程规划许可证', N'GH004', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (13, N'83af32be68924112b8419b5fc0b18413', N'建设工程规划核实', N'GH005', N'', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (14, N'fbd46d61e7654b8594756073a09388e7', N'取水许可审批', N'SL001', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=c15558671fef49f2a2a8c7ead8ac2467&amp;ql_kind=01&amp;iddept_ql_inf=143bcd16c7f84d6f82c27a1a674d5485', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (15, N'fbd46d61e7654b8594756073a09388e7', N'生产建设项目水土保持方案审批', N'SL002', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=104e585ff62a4b92b19184eb226b1bc9&amp;ql_kind=01&amp;iddept_ql_inf=19534e466a69435a8c942cf131cb5184', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (16, N'fbd46d61e7654b8594756073a09388e7', N'洪水影响评价', N'SL003', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/ywList.do?webId=37&amp;iddept_ql_inf=1f1442ff7db54c8d9dda042d8d84c400', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
INSERT [dbo].[pub_approve_guide] ([id], [office_id], [approve_item_label], [approve_item_code], [approve_guide_url], [approve_app_url]) VALUES (17, N'd9343757bad746e9b8d86a371f31d70c', N'建设项目环境影响评价文件审批（不含入海排污口设置审批，不含辐射建设项目）', N'HB001', N'http://wxbh.jszwfw.gov.cn/jszwfw/bscx/itemlist/bszn.do?webId=37&amp;iddept_yw_inf=4682eb799fe7459e834abf761f1c6dbf&amp;ql_kind=01&amp;iddept_ql_inf=3f52733418344b8a9d131150f5584961', N'http://218.94.123.37/tzxmspweb/tzxmweb/pages/dynamic/guide/projectcatalog/bsznjs.jsp')
SET IDENTITY_INSERT [dbo].[pub_approve_guide] OFF
