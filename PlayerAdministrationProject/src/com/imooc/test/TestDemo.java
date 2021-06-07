package com.imooc.test;

import com.imooc.model.PlayListCollection;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.imooc.model.PlayList;
import com.imooc.model.Song;

public class TestDemo {

	PlayListCollection plc = new PlayListCollection();
	static Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		System.out.println("***********************************");
		System.out.println("**主菜单**");
		System.out.println("1--播放列表管理");
		System.out.println("2--播放器管理");
		System.out.println("0--退出");
		System.out.println("***********************************");
	}

	public void playListMenu() {
		System.out.println("***********************************");
		System.out.println("**播放列表管理**");
		System.out.println("1--将歌曲添加到主播放列表");
		System.out.println("2--将歌曲添加到普通播放列表");
		System.out.println("3--通过歌曲ID查询播放列表中的歌曲");
		System.out.println("4--通过歌曲名称查询播放列表中的歌曲");
		System.out.println("5--修改播放列表中的歌曲");
		System.out.println("6--删除播放列表中的歌曲");
		System.out.println("7--显示播放列表中的所有歌曲");
		System.out.println("9--返回上一级菜单");
		System.out.println("***********************************");
	}

	public void playerMenu() {
		System.out.println("***********************************");
		System.out.println("**播放器管理**");
		System.out.println("1--向播放器添加播放列表");
		System.out.println("2--从播放器删除播放列表");
		System.out.println("3--通过名字查询播放列表信息");
		System.out.println("4--显示所有播放列表名称");
		System.out.println("9--返回上一级菜单");
		System.out.println("***********************************");
	}
	
	public void test() {
		while(true) {
			mainMenu();
			System.out.println("请输入对应的数字进行操作：");
			try {
				int n = sc.nextInt();
				if(n == 0) {
					System.out.println("退出程序");
					sc.close();
					System.exit(0);
				}
				switch(n) {
				case 1:
					playListTest();
					break;
				case 2:
					playerTest();
					break;
				default: 
					System.out.println("输入错误，请输入相应的数字进行操作！");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数值");
				sc.next();
			}
		}
	}

	public void playerTest() {
		while (true) {
			playerMenu();
			System.out.println("请输入对应的数字对播放器进行管理：");
			int n = 0;
			try {
				n = sc.nextInt();
				switch (n) {
				case 1:
					System.out.println("向播放器添加播放列表");
					System.out.println("输入要添加的播放列表名称：");
					String listName = sc.next();
					if (plc.searchPlayListByName(listName) != null) {
						System.out.println("该播放列表已存在，不能重复添加");
					} else {
						plc.addPlayList(new PlayList(listName));
					}
					break;
				case 2:
					System.out.println("从播放器删除播放列表");
					System.out.println("请输入要删除的播放列表名称：");
					String listNameInCase2 = sc.next();
					if (listNameInCase2.equals("主播放列表")) {
						System.out.println("主播放列表不能删除");
					} else {
						if (plc.searchPlayListByName(listNameInCase2) == null) {
							System.out.println("该播放列表不存在！");
						} else {
							plc.deletePlayList(plc.searchPlayListByName(listNameInCase2));
							System.out.println("删除成功");
						}
					}
					break;
				case 3:
					System.out.println("通过名字查询播放列表信息");
					System.out.println("请输入要查询的播放列表名称：");
					String listNameInCase3 = sc.next();
					if (plc.searchPlayListByName(listNameInCase3) == null) {
						System.out.println("该播放列表不存在");
					} else {
						System.out.println("该播放列表存在！");
						System.out.println("播放列表的名称为：" + listNameInCase3);
						if(plc.searchPlayListByName(listNameInCase3).getMusicList().isEmpty()) {
							System.out.println("该播放列表中尚未添加歌曲，请先添加歌曲！");
						}
						plc.searchPlayListByName(listNameInCase3).displayAllSong();
					}
					break;
				case 4:
					System.out.println("显示所有播放列表名称");
					plc.displayPlayListName();
					break;
				case 9:
					test();
					break;
				default: 
					System.out.println("输入错误，请输入相应的数字进行操作！");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数值");
				sc.next();
			}
		}
	}

	public void playListTest() {
		boolean flag = false;
		while (true) {
			playListMenu();
			System.out.println("请输入对应的数字对播放列表进行管理：");
			int n = 0;
			try {
				n = sc.nextInt();
				switch (n) {
				case 1:
					System.out.println("将歌曲添加到主播放列表");
					do {
						System.out.println("请输入要添加的歌曲的数量：");
						try {
							int sum = sc.nextInt();
							flag = false;
							for (int i = 1; i <= sum; i++) {
								System.out.println("请输入第" + i + "首歌曲：");
								System.out.println("请输入歌曲的id：");
								String strId = sc.next();
								if (plc.searchPlayListByName("主播放列表").searchSongById(strId) != null) {
									System.out.println("该歌曲ID在主播放列表中已存在，请重新输入");
									i--;
								} else {
									System.out.println("请输入歌曲的名称：");
									String strName = sc.next();
									System.out.println("请输入演唱者：");
									String strSinger = sc.next();
									plc.searchPlayListByName("主播放列表")
											.addToPlayList(new Song(strId, strName, strSinger));
								}
							}
						} catch (InputMismatchException e) {
							System.out.println("键入数据格式错误，请输入数值");
							sc.next();
							flag = true;
						}
					} while (flag);
					break;
				case 2:
					System.out.println("将歌曲添加到普通播放列表");
					System.out.println("请输入要添加的播放列表名称：");
					String listNameInCase2 = sc.next();
					if (plc.searchPlayListByName(listNameInCase2) == null) {
						System.out.println("该播放列表不存在！");
					} else {
						do {
							System.out.println("请输入要添加的歌曲的数量：");
							try {
								int sum = sc.nextInt();
								flag = false;
								for (int i = 1; i <= sum; i++) {
									System.out.println("请输入第" + i + "首歌曲：");
									System.out.println("请输入歌曲的id：");
									String strId = sc.next();
									if (plc.searchPlayListByName(listNameInCase2).searchSongById(strId) != null) {
										System.out.println("该歌曲ID在" + listNameInCase2 + "中已存在，请重新输入");
										i--;
									} else {
										if (plc.searchPlayListByName("主播放列表").searchSongById(strId) == null) {
											System.out.println("该歌曲在主播放列表不存在，继续输入歌曲的其他信息！");
											System.out.println("请输入歌曲名称：");
											String strName = sc.next();
											System.out.println("请输入演唱者：");
											String strSinger = sc.next();
											plc.searchPlayListByName("主播放列表")
													.addToPlayList(new Song(strId, strName, strSinger));
										}
										plc.searchPlayListByName(listNameInCase2)
												.addToPlayList(plc.searchPlayListByName("主播放列表").searchSongById(strId));
									}
								}
								System.out.println("主播放列表：");
								plc.searchPlayListByName("主播放列表").displayAllSong();
								System.out.println("普通播放列表：");
								plc.searchPlayListByName(listNameInCase2).displayAllSong();
							} catch (InputMismatchException e) {
								System.out.println("键入数据格式错误，请输入数值");
								sc.next();
								flag = true;
							}
						} while (flag);
					}
					break;
				case 3:
					System.out.println("通过歌曲ID查询播放列表中的歌曲");
					System.out.println("请输入要查询的播放列表名称：");
					String listNameInCase3 = sc.next();
					if (plc.searchPlayListByName(listNameInCase3) == null) {
						System.out.println("该播放列表不存在");
					} else {
						System.out.println("请输入要查询的歌曲ID：");
						String strId = sc.next();
						if (plc.searchPlayListByName(listNameInCase3).searchSongById(strId) != null) {
							System.out.println("该歌曲的信息为：");
							System.out.println(plc.searchPlayListByName(listNameInCase3).searchSongById(strId));
						} else {
							System.out.println("该歌曲在" + listNameInCase3 + "中不存在！");
						}
					}
					break;
				case 4:
					System.out.println("通过歌曲名称查询播放列表中的歌曲");
					System.out.println("请输入要查询的播放列表名称：");
					String listNameInCase4 = sc.next();
					if (plc.searchPlayListByName(listNameInCase4) == null) {
						System.out.println("该播放列表不存在");
					} else {
						System.out.println("请输入要查询的歌曲名：");
						String strName = sc.next();
						if (plc.searchPlayListByName(listNameInCase4).searchSongByName(strName) != null) {
							System.out.println("该歌曲的信息为：");
							System.out.println(plc.searchPlayListByName(listNameInCase4).searchSongByName(strName));
						} else {
							System.out.println("该歌曲在" + listNameInCase4 + "中不存在！");
						}
					}
					break;
				case 5:
					System.out.println("修改播放列表中的歌曲");
					System.out.println("请输入播放列表名称：");
					String listNameInCase5 = sc.next();
					if (plc.searchPlayListByName(listNameInCase5) == null) {
						System.out.println("该播放列表不存在");
					} else {
						System.out.println("请输入要修改的歌曲ID：");
						String strId = sc.next();
						if (plc.searchPlayListByName(listNameInCase5).searchSongById(strId) != null) {
							System.out.println("请输入新歌曲的名称：");
							String strName = sc.next();
							System.out.println("请输入新歌曲的演唱者");
							String strSinger = sc.next();
							plc.searchPlayListByName(listNameInCase5).updateSong(strId,
									new Song(strId, strName, strSinger));
						} else {
							System.out.println("该歌曲在" + listNameInCase5 + "中不存在！");
						}
					}
					break;
				case 6:
					System.out.println("删除播放列表中的歌曲");
					System.out.println("请输入播放列表名称：");
					String listNameInCase6 = sc.next();
					if (plc.searchPlayListByName(listNameInCase6) == null) {
						System.out.println("该播放列表不存在");
					} else {
						System.out.println("请输入要删除的歌曲ID：");
						String strId = sc.next();
						if (plc.searchPlayListByName(listNameInCase6).searchSongById(strId) != null) {
							plc.searchPlayListByName(listNameInCase6).deleteSong(strId);
						} else {
							System.out.println("该歌曲在" + listNameInCase6 + "中不存在！");
						}
					}
					break;
				case 7:
					System.out.println("显示播放列表中的所有歌曲");
					System.out.println("请输入播放列表名称：");
					String listNameInCase7 = sc.next();
					if (plc.searchPlayListByName(listNameInCase7) == null) {
						System.out.println("该播放列表不存在");
					} else {
						if (plc.searchPlayListByName(listNameInCase7).getMusicList().size() == 0) {
							System.out.println("该播放列表尚未添加歌曲，请先添加歌曲");
						} else {
							plc.searchPlayListByName(listNameInCase7).displayAllSong();
						}
					}
					break;
				case 9:
					test();
					break;
				default:
					System.out.println("输入错误，请输入相应的数字进行操作！");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("键入数据格式错误，请输入数值");
				sc.next();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDemo td = new TestDemo();
		td.test();
	}

}
