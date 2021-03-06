
-- 新增显示状态
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10001', N'0', N'正常', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10002', N'1', N'不显示', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10004', N'-1', N'删除', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10004', N'4', N'变更', N'display_flag', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')

-- 批复结果新增批复文号类型、年份、编号
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_type varchar(64) null;
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_year varchar(10) null;
 alter table [MajorProjectLib].[dbo].[pub_approve_result] add approve_num_num varchar(10) null;

 -- 行政处罚字段扩展长度
 alter table [MajorProjectLib].[dbo].[pub_admin_penalty] alter column punish_result varchar(500) null

 -- 住建项目增加统一项目代码字段
  alter table [MajorProjectLib].[dbo].[TBProjectInfo] add PROJECT_CODE varchar(32) null; 

-- 新增施工期环境保护
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10101', N'0', N'是', N'environment_close', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')
INSERT [MajorProjectLib].[dbo].[sys_dict] ([id], [value], [label], [type], [description], [sort], [parent_id], [create_by], [create_date], [update_by], [update_date], [remarks], [del_flag]) VALUES (N'10103', N'1', N'否', N'environment_close', N'显示标记', CAST(10 AS Decimal(10, 0)), N'0', N'1', CAST(0x0000A1CB0083D600 AS DateTime), N'1', CAST(0x0000A1CB0083D600 AS DateTime), NULL, N'0')

  update [MajorProjectLib].[dbo].[sys_dict] set label = '已设置' 
  where type = 'environment_close' and value = '0'
    update [MajorProjectLib].[dbo].[sys_dict] set label = '未设置' 
  where type = 'environment_close' and value = '1'
  
-- 新增发改项目需调整的字段，规模和内容
alter table [MajorProjectLib].[dbo].[pub_project] add  SCALE_CONTENT varchar(255) null