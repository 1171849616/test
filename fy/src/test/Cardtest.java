package test;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Cardtest {
	//创建新列表
	private static ArrayList<Card> cardlist;

	// 柱状图生成
	static ChartPanel frame1;
	static int x, y, n;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 导入疫情信息
		cardlist = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		File file = new File("E:\\疫情.txt");
		int k;
		String p, q;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String temp = null;

			while ((temp = in.readLine()) != null) {
				Scanner linescanner = new Scanner(temp);
				linescanner.useDelimiter(" ");
				String name = linescanner.next();
				String id = linescanner.next();
				String a = linescanner.next();
				String b = linescanner.next();
				String c = linescanner.next();
				String d = linescanner.next();
				String e = linescanner.next();
				String f = linescanner.next();
				String g = linescanner.next();

				String time = linescanner.nextLine();

				Card card = new Card();
				card.setName(name);
				card.setId(id);
				card.setA(a);
				card.setB(b);
				card.setC(c);
				card.setD(d);
				card.setE(e);
				card.setF(f);
				card.setG(g);

				card.setTime(time);

				cardlist.add(card);
				x = cardlist.size();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("信息文件找不到");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("信息文件读取错误");
			e.printStackTrace();
		}
		// 具体操作流程
		boolean isTrue = true;
		while (isTrue) {
			show();
			int nextInt = scanner.nextInt();
			switch (nextInt) {
			// 1.列出疫情信息
			case 1:
				title();
				System.out.println(cardlist.toString());
				break;
			// 2.输入日期查看
			case 2:
				System.out.println("输入时间：");
				String time = scanner.next();

				p = time.substring(0, 9);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getTime().substring(1, 10).equals(p)) {
						System.out.println(cardlist.get(i));
						k++;
					}
				}
				if (k == 0)
					System.out.println("当天无记录！");
				else
					System.out.println("在" + time + "参与统计的人数\n" + k);
				break;
			// 3.输入姓名查看
			case 3:
				System.out.println("输入姓名：");
				String name = scanner.next();
				p = name.substring(0, 3);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getName().substring(0, 3).equals(p)) {
						System.out.println(cardlist.get(i));
						k++;
					}
				}
				if (k == 0)
					System.out.println("查无此人！");
				else
					System.out.println("此人有" + k + "条记录\n");
				break;
			// 4.输入学号查看
			case 4:
				System.out.println("输入学号：");
				String id = scanner.next();
				p = id.substring(0, 12);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getId().substring(0, 12).equals(p))
						System.out.println(cardlist.get(i));
					k++;
				}
				if (k == 0)
					System.out.println("学号不存在！");
				break;
			// 5.查看某人在某天的情况
			case 5:
				System.out.println("输入学号");
				String id1 = scanner.next();
				p = id1.substring(0, 12);
				System.out.println("输入日期");
				String time1 = scanner.next();
				q = time1.substring(0, 9);
				k = 0;
				title();
				for (int i = 0; i < cardlist.size(); i++) {
					if (cardlist.get(i).getId().substring(0, 12).equals(p)) {
						if (cardlist.get(i).getTime().substring(1, 10).equals(q)) {
							System.out.println(cardlist.get(i));
							k++;
						}
					}
				}
				if (k == 0)
					System.out.println("没有结果");
				break;
			// 6.按具体情况查看
			case 6: {
				System.out.println(
						"输入想查询的防疫信息：\"请选择操作：(1.是否发热，2.是否为留校学生，3.是否在湖北，4.是否与湖北疫区人员接触，5.是否在武汉，6.是否与武汉疫区人员接触，7.今天是否从外地返校)");
				k = scanner.nextInt();
				switch (k) {
				case 1: {
					System.out.println("是否发热");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;

					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getA().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("发热人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getA().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("未发热人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");

						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}
				case 2: {
					System.out.println("是否为留校学生");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getB().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("留校学生人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getB().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("未留校学生人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}
				case 3: {
					System.out.println("是否在湖北");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getC().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("在湖北人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getC().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("不在湖北人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}
				case 4: {
					System.out.println("是否与湖北疫区人员接触");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getD().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("与湖北疫区人员接触人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getD().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("未与湖北疫区人员接触人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}
				case 5: {
					System.out.println("是否在武汉");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getE().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("在武汉人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getE().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("不在武汉人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}
				case 6: {
					System.out.println("是否与武汉疫区人员接触");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getF().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("与武汉疫区人员接触人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getF().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("未与武汉疫区人员接触人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}

				case 7: {
					System.out.println("今天是否从外地返校");
					String a = scanner.next();
					p = a.substring(0, 1);
					n = 0;
					y = 0;
					if (a.equals("是")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getG().substring(0, 1).equals(p))
								y++;
						}
						System.out.println("今天从外地返校人数为：" + y);
						n = x - y;
					}

					else if (a.equals("否")) {
						for (int i = 0; i < cardlist.size(); i++) {
							if (cardlist.get(i).getG().substring(0, 1).equals(p))
								n++;
						}
						System.out.println("今天未从外地返校人数为：" + n);
						y = x - n;
					}

					// 生成柱状图

					System.out.println("是否要生成柱状图：");
					String b = scanner.next();

					if (b.equals("是")) {
						System.out.println("展示数据列表：");
						Test();
						JFrame frame = new JFrame("该数据的数量统计");
						frame.setLayout(new GridLayout(2, 2, 5, 5));
						frame.add(new Cardtest().getChartPanel()); // 添加柱形图
						frame.setBounds(0, 0, 500, 400);
						frame.setVisible(true);
					} else if (b.equals("否")) {

						System.out.println("退出中");

					}
					break;
				}
				}
				break;
			}
			// 退出程序
			case 7:
				isTrue = false;
				System.out.println("程序已退出!");
				break;
			default:
				System.out.println("输入有误");
			}
		}

	}

	// 系统主菜单
	private static void show() {
		// TODO 自动生成的方法存根
		System.out.println("欢迎来到疫情查询系统,请选择你的操作");
		System.out.println("1.列出疫情信息");
		System.out.println("2.输入日期查看");
		System.out.println("3.输入姓名查看");
		System.out.println("4.输入学号查看");
		System.out.println("5.输入学号、日期查看");
		System.out.println("6.按具体情况查看");
		System.out.println("7.退出");
	}

	// 疫情信息
	private static void title() {
		// TODO 自动生成的方法存根
		System.out.println("姓名\t学号\t有无发热\t是否为留校学生\t是否在湖北\t是否与湖北疫区人员接触\t是否在武汉\t是否与武汉疫区人员接触\t是否今天从外地返校 时间");

	}

	// 生成柱状图
	private static void Test() {
		// TODO 自动生成的方法存根
		CategoryDataset dataset = getDataSet();// 将获得的数据传递给CategoryDataset类的对象
		JFreeChart chart = ChartFactory.createBarChart3D("人数统计表", // 图表标题
				"人数信息", // 目录轴的显示标签
				"人数/个", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体

		frame1 = new ChartPanel(chart, true); // 这里也可以用chartFrame,可以直接生成一个独立的Frame

	}

	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(y, "是", "是");
		dataset.addValue(n, "否", "否");
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}
}
