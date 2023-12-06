USE [javaProject]
GO
/****** Object:  Table [dbo].[Credit_Manage]    Script Date: 2023/12/6 10:39:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Credit_Manage](
	[id] [varchar](10) NOT NULL,
	[event] [varchar](20) NOT NULL,
	[event_credit] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Money_Manage]    Script Date: 2023/12/6 10:39:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Money_Manage](
	[id] [varchar](10) NOT NULL,
	[money] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 2023/12/6 10:39:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[cnt] [int] IDENTITY(1,1) NOT NULL,
	[id] [varchar](10) NOT NULL,
	[name] [varchar](10) NOT NULL,
	[age] [int] NOT NULL,
	[major] [varchar](20) NOT NULL,
	[phone] [varchar](11) NULL,
	[credit] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[cnt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Manage]    Script Date: 2023/12/6 10:39:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Manage](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210439058', N'我爱微积分', 0.5)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210439058', N'计算机协会讲座', 0.5)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210439058', N'活动一', 0.3)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210439058', N'活动二', 0.4)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210000001', N'讲座A', 0.2)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210000002', N'校数学竞赛', 0.5)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210000002', N'省数学竞赛', 0.6)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210439058', N'JAVA实训', 0.5)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210000001', N'活动一', 0.3)
INSERT [dbo].[Credit_Manage] ([id], [event], [event_credit]) VALUES (N'3210000002', N'国数学竞赛', 0.8)
GO
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3210439058', 19988.8)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3210000001', 5000)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3200000001', 2900)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3200000002', 1000)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3220000001', 10000)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3220000002', 6664)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3220000003', 1234)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3210000002', 9876)
INSERT [dbo].[Money_Manage] ([id], [money]) VALUES (N'3190000001', 5555)
GO
SET IDENTITY_INSERT [dbo].[Student] ON 

INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (3, N'3210000001', N'王一', 21, N'大数据', N'18757898611', 0.5)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (4, N'3200000001', N'王二', 22, N'大数据', N'18757898611', 0)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (5, N'3200000002', N'王三', 22, N'计算机', N'18757898611', 0)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (6, N'3220000001', N'李一', 20, N'英语', N'18757898611', 0)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (7, N'3220000002', N'李二', 20, N'英语', N'18757898611', 0)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (8, N'3220000003', N'李三', 20, N'日语', N'18757898611', 0)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (9, N'3210000002', N'李四', 21, N'会计学', N'18757898611', 1.9)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (10, N'3190000001', N'张一', 23, N'计算机', N'18757898611', 0)
INSERT [dbo].[Student] ([cnt], [id], [name], [age], [major], [phone], [credit]) VALUES (18, N'3210439058', N'ZYL', 21, N'大数据', N'18757898611', 2.2)
SET IDENTITY_INSERT [dbo].[Student] OFF
GO
INSERT [dbo].[User_Manage] ([username], [password]) VALUES (N'admin1', N'666666')
INSERT [dbo].[User_Manage] ([username], [password]) VALUES (N'admin2', N'888888')
INSERT [dbo].[User_Manage] ([username], [password]) VALUES (N'admin3', N'000000')
INSERT [dbo].[User_Manage] ([username], [password]) VALUES (N'admin4', N'111111')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Student__3213E83E5C0556F7]    Script Date: 2023/12/6 10:39:14 ******/
ALTER TABLE [dbo].[Student] ADD UNIQUE NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Credit_Manage]  WITH CHECK ADD FOREIGN KEY([id])
REFERENCES [dbo].[Student] ([id])
GO
ALTER TABLE [dbo].[Money_Manage]  WITH CHECK ADD CHECK  (([money]>=(0)))
GO
