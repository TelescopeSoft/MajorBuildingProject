
-- 新增显示状态
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10001', N'0', N'正常', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10002', N'1', N'不显示', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10003', N'-1', N'删除', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')


-- 批复结果新增批复文号类型、年份、编号
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_type varchar(64) null;
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_year varchar(10) null;
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_num varchar(10) null;
