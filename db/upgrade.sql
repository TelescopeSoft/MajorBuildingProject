
-- ������ʾ״̬
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10001', N'0', N'����', N'display_flag', N'��ʾ���', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10002', N'1', N'����ʾ', N'display_flag', N'��ʾ���', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10003', N'-1', N'ɾ��', N'display_flag', N'��ʾ���', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')


-- ����������������ĺ����͡���ݡ����
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_type varchar(64) null;
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_year varchar(10) null;
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_num varchar(10) null;
