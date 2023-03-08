package com.itheima.startmoves;
import com.itheima.VerificationCode.VerificationCode;
import com.itheima.moves.Business;
import com.itheima.moves.Customer;
import com.itheima.moves.Movie;
import com.itheima.moves.Uset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class moviestret {
    /**
     * 键盘录入自动导包。2.键盘扫描对象。
     */
    public static final Scanner sc = new Scanner(System.in);
    /**
     * 定义日记对象
     */
    public static final Logger LOGGER = LoggerFactory.getLogger("moviestret.class");

    /**
     * 集合用户,Business  customer容器商家和用户
     */
    public static final List<Uset> lists = new ArrayList<>();
    /**
     * 定义一个商家,存储电影(p1,p2 p3,...)
     * list(p1,p2,...)hashMap如果存储是自定义对象,需要重写equals和hashcode方法
     */
    public static final Map<Business, List<Movie>> Businesss = new HashMap<>();
    /**
     * 定义一个用户类,存储已看电影(p1,p2 p3,...)
     * list(p1,p2,...)hashMap如果存储是自定义对象,需要重写equals和hashcode方法
     */
    public static final Map<Customer, List<Movie>> Customerss = new HashMap<>();

    /**
     * 喜欢时间形式
     */
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * loguser是新账号
     */
    public static Uset loguser;

    /**
     * 代码块
     */

    static {
        //b1,b2  2个用户
        Customer c1 = new Customer();
        c1.setLoginName("用户1");//登录名
        c1.setUsetName("xiao小");
        c1.setPassWord("123456");
        c1.setSex('女');
        c1.setPhone("1256415545");
        c1.setMoney(1000);
        lists.add(c1);
        List<Movie> Listb4 = new ArrayList<>();
        Customerss.put(c1, Listb4);


        Customer c2 = new Customer();
        c2.setLoginName("用户2");//登录名
        c2.setUsetName("xiao小");
        c2.setPassWord("123456");
        c2.setSex('女');
        c2.setPhone("1256415545");
        c2.setMoney(1000);
        lists.add(c2);
        List<Movie> Listb3 = new ArrayList<>();
        Customerss.put(c2, Listb3);

        //b1,b2  2个商家
        Business b1 = new Business();
        b1.setLoginName("商家1"); //登录名
        b1.setUsetName("chanxiaowei");
        b1.setSex('男');
        b1.setPassWord("123456");
        b1.setPhone("13715482545");
        b1.setShopName("中国电影有限公司");
        b1.setMoney(0);
        b1.setAddress("广东阳江");
        lists.add(b1);
        List<Movie> Listb1 = new ArrayList<>();
        Businesss.put(b1, Listb1);

        Business b2 = new Business();
        b2.setLoginName("商家2");  //登录名
        b2.setUsetName("lixiaolong");
        b2.setSex('男');
        b2.setPassWord("123456");
        b2.setPhone("13715482584");
        b2.setShopName("国际电影网");
        b2.setMoney(0);
        b2.setAddress("广东茂名");
        lists.add(b2);
        //电影
        //  Movie m1 = new Movie();
       /* m1.setName("离校路");
        m1.setActor("小三");
        m1.setScore(0);
        m1.setTime(60);
        m1.setPrice(150);
        m1.setNumber(15);
        try {
            m1.setStartTime(sdf.parse("2022-06-17 11:11:11"));//解析时间);
        } catch (Exception e) {
            e.printStackTrace();
        }

        */

        //     Listb1.add(m1);


        //  Movie m2 = new Movie();
/*
        m2.setName("长京二号"); //电影名
        m2.setActor("小二");  //主演
        m2.setScore(0);  //评分
        m2.setTime(68);   //分钟
        m2.setPrice(150);//票价
        m2.setNumber(10);//票数
        try {
            m2.setStartTime(sdf.parse("2022-07-15 11:11:11"));//解析时间);
        } catch (Exception e) {
            e.printStackTrace();
        }

 */

        List<Movie> Listb2 = new ArrayList<>();
        //  Listb2.add(m2);
        Businesss.put(b2, Listb2);
    }

    /**
     * 启动包
     *
     * @return
     */
    public static Business getaSystem() throws Exception {
        while (true) {
            System.out.println("---------欢迎进入小马哥电影系统------------");
            System.out.println("1.登录");
            System.out.println("2.用户注册");
            System.out.println("3.商家注册");
            System.out.println("请选择1,  2 , 3 命令:");
            String command = sc.nextLine();
            switch (command) {
                case "1":
                    //登录
                    GetLogin();
                    break;
                case "2":
                    //用户注册
                    UserRegistration();
                    break;
                case "3":
                    //商家注册
                    MerchantRegistration();
                    break;
                default:
                    System.out.println("没有这个命令,请重新输入");
            }

        }

    }

    /**
     * 商家注册首页
     */
    private static void MerchantRegistration() throws Exception {
        //  定义一个商家对象
        try {
            Uset business = new Business();
            while (true) {
                System.out.println("-------欢迎小码哥商家注册界面-----------");

                System.out.println("请商家注册账号");
                String UsetRegisterLoginName = sc.nextLine();
                //定义一个方法查 账号是否重复
                String UsetRegisterName = WhetherTheAccountIsRepeated(UsetRegisterLoginName);
                if (UsetRegisterName != null) {
                    System.out.println("账号重复,请重新输入");
                    continue;
                }
                //账号不重复 可以用
                business.setLoginName(UsetRegisterLoginName);
                System.out.println("请真实姓名");//以这个做为忘记密码的开锁
                String usetname = sc.nextLine();
                business.setUsetName(usetname);

                System.out.println("请输入性别");
                String sex = sc.nextLine();
                business.setSex(sex.charAt(0));
                System.out.println("请输入电话");
                String phone = sc.nextLine();
                business.setPhone(phone);
                //输入商家店铺名
                System.out.println("输入商家店铺名");
                String shopname = sc.nextLine();
                //输入商家店铺地址
                System.out.println("输入商家店铺地址");
                String address = sc.nextLine();
                while (true) {
                    System.out.println("请注册密码");
                    String passWord = sc.nextLine();
                    System.out.println("请重新输入密码");
                    String OKpassWord = sc.nextLine();
                    //判断密码是否一致
                    if (OKpassWord.equals(passWord)) {
                        business.setPassWord(OKpassWord);
                        //密码成功
                        lists.add(business);
                        if (business instanceof Business) {
                            //List添加到Businesss集合中
                            List<Movie> List = new ArrayList<>();
                            Business usets = (Business) business;
                            //商家店铺名.店铺地址添加List集合中
                            usets.setShopName(shopname);
                            usets.setAddress(address);
                            //business添加到lists集合中
                            lists.add(usets);
                            Businesss.put(usets, List);
                            //把business商家当前复制一份
                            loguser = usets;
                            //商家展示页面
                            MerchantDisplayPage();
                        }
                        return;
                    } else {
                        //  密码不一致
                        System.out.println("密码不一致,请重新输入密码");

                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("商家注册首页出现异常");
        }
    }


    /**
     * 用户注册首页
     */
    private static void UserRegistration() {
        //  定义一个用户对象
        Uset Customers = new Customer();
        try (
                //对象序列化(高)存入文件中去
                ObjectOutputStream obst = new ObjectOutputStream(new FileOutputStream("D:\\idea1\\Total\\" +
                        "TotalProject\\FilmSystem\\save\\save01.txt"))) {
            while (true) {
                System.out.println("-------欢迎小码哥用户注册界面-----------");
                System.out.println("请用户注册账号");
                String UsetRegisterLoginName = sc.nextLine();
                //定义一个方法查 账号是否重复
                String UsetRegisterName = WhetherTheAccountIsRepeated(UsetRegisterLoginName);
                if (UsetRegisterName != null) {
                    System.out.println("账号重复,请重新输入");
                    continue;
                }


                //账号不重复 可以用
                Customers.setLoginName(UsetRegisterLoginName);
                System.out.println("请真实姓名");//以这个做为忘记密码的开锁
                String usetname = sc.nextLine();
                Customers.setUsetName(usetname);

                System.out.println("请输入性别");
                String sex = sc.nextLine();
                Customers.setSex(sex.charAt(0));
                System.out.println("请输入电话");
                String phone = sc.nextLine();
                Customers.setPhone(phone);
                while (true) {
                    System.out.println("请注册密码");
                    String passWord = sc.nextLine();
                    System.out.println("请重新输入密码");
                    String OKpassWord = sc.nextLine();
                    //判断密码是否一致
                    if (OKpassWord.equals(passWord)) {
                        Customers.setPassWord(OKpassWord);
                        System.out.println("用户登录成功");

                        //存入文件中
                        //    Uset u = Auditnumber(Customers.getLoginName());
                        //   obst.writeObject(Customers);

                        if (Customers instanceof Customer) {

                            Customer cbuset = (Customer) Customers;
                            lists.add(cbuset);

                            //List添加到Customerss集合中
                            List<Movie> movies = new ArrayList<>();
                            Customerss.put(cbuset, movies);
                            //把Customers用户当前复制一份
                            loguser = cbuset;
                            // 用户展示页面
                            UserDisplayPage();
                        }
                        return;
                    } else {
                        //  密码不一致
                        System.out.println("密码不一致,请重新输入密码");
                    }
                }
            }


        } catch (
                Exception e) {
            e.printStackTrace();
            LOGGER.error("用户注册首页出现异常");
        }

    }

    /**
     * 用户注册查账号是否重复
     *
     * @param UsetRegisterLoginName 用户
     * @return 新用户账号
     */
    private static String WhetherTheAccountIsRepeated(String UsetRegisterLoginName) {
        //遍历所有账号
        for (Uset list : lists) {

            if (list.getLoginName().equals(UsetRegisterLoginName)) {
                //    查到账号重复返回
                return list.getLoginName();

            }
        }


        return null;
    }

    /**
     * 登录功能
     */
    private static void GetLogin() throws Exception {
        System.out.println("-------欢迎小码哥登录界面-----------");
        System.out.println("测试用:账号:用户1 密码123456     账号:商家1 密码123456   ");
        try {
            while (true) {
                System.out.println("请输入账号");
                String loginName = sc.nextLine();
                //用户查询账号是否存在
                //定义个方法 查账号 u是返回用户
                Uset u = Auditnumber(loginName);
                if (u != null) {
                    System.out.println("账号正确.");
                    // loguser=u 是 新账号
                    loguser = u;
                    break;
                } else {
                    System.out.println("您登录账号不正确还要继续y/n吗?");
                    String command = sc.nextLine();//命令
                    switch (command) {
                        case "y":
                            System.out.println("请重新输入账号.");
                            break;
                        default:
                            System.out.println("好的");
                            return;
                    }
                }
            }


            while (true) {
                System.out.println("请输入密码");
                String passWord = sc.nextLine();
                //用户 商家一定存在
                if (loguser.getPassWord().equals(passWord)) {
                    //      System.out.println("密码登录成功");
                    break;

                } else {
                    System.out.println("您登录密码不正确,请重新输入");

                }
            }

            //验证码和密码一致
            //验证码
            while (true) {

                //定义个方法产生 验证码

                String code = VerificationCode.GetVerificationCode(4);
                // 打印验证码
                System.out.println("4位验证码是:" + code);
                System.out.println("请输入验证码");
                String okVerificationCode = sc.nextLine();
                if (code.equalsIgnoreCase(okVerificationCode)) {
                    System.out.println("验证码正确");
                    System.out.println("密码登录成功");
                    // 用户 商家登录成功
                    if (loguser instanceof Business) {
                        //商家展示页面
                        MerchantDisplayPage();
                        return;
                    } else {

                        // 用户展示页面
                        UserDisplayPage();
                        return;
                    }
                } else {
                    System.out.println("验证码不对 请重新录入");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * lists查账号
     * loginName登录账号
     */
    private static Uset Auditnumber(String loginName) throws Exception {
        for (int i = 0; i < lists.size(); i++) {
            Uset uset = lists.get(i);
            if (uset.getLoginName().equals(loginName)) {
                //登录名存在
                return uset;
            }
        }

        return null;
    }

    /**
     * 商家展示页面
     */
    private static void MerchantDisplayPage() throws Exception {
        while (true) {
            System.out.println("-------欢迎进入小码哥商家------------");
            System.out.println(loguser.getLoginName() + (loguser.getSex() == '男' ? "先生" : "女士") + "你好,请选择商家操作页面");
            System.out.println("1展示详情");
            System.out.println("2.上架电影");
            System.out.println("3.下架电影");
            System.out.println("4.修改电影");
            System.out.println("5.退出");
            String command = sc.nextLine();
            switch (command) {
                case "1":
                    //展示电影详情 信息
                    GethowMovieDetails();
                    break;
                case "2":
                    //上架电影信息
                    GetMovieInformation();
                    break;
                case "3":
                    //下架电影 信息
                    GetTakeDownAMovie();
                    break;
                case "4":
                    //修改电影信息
                    GetmodifyMovie();
                    break;
                case "5":
                    //退出
                    System.out.println("退出回到首页");
                    return;
                default:
                    System.out.println("没有这个命令,请重新输入");
            }
        }

    }

    /**
     * 商家修改loguser3商家电影信息页面
     */
    private static void GetmodifyMovie () {
        while (true) {
        System.out.println("-------修改影片信息页面-----------");
        //商家loguser3
        Business loguser3 = (Business) loguser;
        List<Movie> movies = Businesss.get(loguser3);
     //   if (movies.size()==0) {
         //   System.out.println("没有影片修改");
        //    return;
      //  }
            //修改loguser3商家电影信息页面
            System.out.println("请输入修改电影片名的");
            String Getname = sc.nextLine();
            for (Movie movie : movies) {
                if (movie.getName().contains(Getname)) {
                    //要修改的影片movie
                    System.out.println("修改电影片名");
                    String name = sc.nextLine();
                    System.out.println("修改电影主演");
                    String actor = sc.nextLine();
                    System.out.println("修改电影多少分钟");
                    String time = sc.nextLine();
                    System.out.println("修改电影价格");
                    String price = sc.nextLine();
                    System.out.println("修改电影票数");
                    String number = sc.nextLine();
                    System.out.println("修改放映时间");
                    String startTime = sc.nextLine();
                    movie.setName(name);
                    movie.setActor(actor);
                    movie.setTime(Double.valueOf(time));
                    movie.setPrice(Double.valueOf(price));
                    movie.setNumber(Integer.valueOf(number));

                    try {
                        movie.setStartTime(sdf.parse(startTime));//放映时间
                        System.out.println("成功修改的影片");
                        GethowMovieDetails();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        LOGGER.error("您的时间不对,请重新输入");
                    }

                } else {
                    System.out.println("没有影片修改");
                    System.out.println("请问还要继续y/n吗?");
                    String command = sc.nextLine();//命令
                    switch (command) {
                        case "y":
                            break;
                        default:
                            System.out.println("好的");
                            return;
                    }
                }
            }
        }

    }

    /**
     * 商家下架电影信息
     */
    private static void GetTakeDownAMovie() {

        System.out.println("------下架电影信息操作页面-----------");
        //展示电影详情
        Business loguser3 = (Business) loguser;
        List<Movie> Movies = Businesss.get(loguser3);
        //请输入删除要下架的电影名字
      //  if (Movies.size()<=0) {
       //     System.out.println("此商家没有影片,请按2上架电影,或按5.退出");
        //    return;
      //  }


        System.out.println("要下架的电影名字");
        String name = sc.nextLine();

        for (int i = 0; i < Movies.size(); i++) {
            if (Movies.get(i).getName().contains(name)) {
                //已经下架电影
                Movies.remove(Movies.get(i));
                i--;
                System.out.println("您成功下架电影啦!");
                GethowMovieDetails();
            } else {
                System.out.println("电影下架不了");
            }
        }
    }


    /**
     * 商家展示loguser3电影详情信息
     */
    private static void GethowMovieDetails()
    {
        System.out.println("---------展示电影详情信息如下------------");
        Business loguser3 = (Business) loguser;
        System.out.println("登录名:" + loguser3.getLoginName() + "\t\t店铺名称:" + loguser3.getShopName() + "\t\t店铺地址:" + loguser3.getAddress());
        System.out.println("真名:" + loguser3.getUsetName() + "\t\t性别:" + loguser3.getSex() + "\t\t电话:" + loguser3.getPhone() + "\t\t余额:" + loguser3.getMoney());

        //根据商家名取值
        List<Movie> movies = Businesss.get(loguser);
        System.out.println("电影片名\t\t\t主演\t\t\t评分\t\t\t分钟\t\t\t票价\t\t\t余票数\t\t\t放映时间");
        for (Movie movie : movies) {
            if (movies.size() > 0) {
                System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t\t" + movie.getScore() + "\t\t\t"
                        + movie.getTime() + "\t\t" + movie.getPrice() + "\t\t" + movie.getNumber() + "\t\t\t" +
                        sdf.format(movie.getStartTime()));

            } else {
                System.out.println("商家没有影片可播,请按2.上架影片.或按5.退出.");
            }
        }
    }

    /**
     * 商家上架m3电影信息到loguser3是新添加当前商家
     */
    private static void GetMovieInformation() throws Exception {

        while (true) {
            System.out.println("---------商家上架电影信息---------------");

            //loguser3是新添加商家
            Business loguser3 = (Business) loguser;
            //添加电影
            System.out.println("请添加电影名");
            String addname = sc.nextLine();
            //方法查影片名是否重复
            Movie movie = FindAMovie(addname);
            if (movie != null) {
                //addname已重复
                System.out.println("您影片已重复,请重新输入影片名.");
                continue;
            }

            System.out.println("请添加电影主演");
            String addactor = sc.nextLine();

            System.out.println("请添加电影多少分钟");
            String addtime = sc.nextLine();
            System.out.println("请添加电影价格");
            String price = sc.nextLine();
            System.out.println("请添加电影票数");
            String addnumber = sc.nextLine();
            System.out.println("请添加放映时间");
            String addstartTime = sc.nextLine();

            Movie m = new Movie();
            m.setName(addname);
            m.setActor(addactor);
            m.setTime(Double.valueOf(addtime));
            m.setPrice(Double.valueOf(price));
            m.setNumber(Integer.valueOf(addnumber));

            m.setStartTime(sdf.parse(addstartTime));//放映时间
            List<Movie> movies = Businesss.get(loguser3);
            movies.add(m);
            System.out.println("成功上架一个电影是:" + m.getName());
            // 展示电影
            GethowMovieDetails();
            return;
        }


    }


    /**
     * 用户展示页面
     */
    private static void UserDisplayPage() {
        try {
            while (true) {
                System.out.println("展示" + loguser.getLoginName() + "\t\t\t性别" + loguser.getSex() + "\t\t\t电话" + loguser.getPhone() + "\t\t\t余额" + loguser.getMoney());
                System.out.println("-------欢迎进入小码哥用户------------");
                System.out.println("请选择操作功能");
                System.out.println("1展示全部影片");
                System.out.println("2展示已看影片");
                System.out.println("3.根据电影名称查询电影");
                System.out.println("4.评分功能");
                System.out.println("5.购票功能");
                System.out.println("6.充值功能");
                System.out.println("7.退出系统");
                String command = sc.nextLine();
                switch (command) {
                    case "1":
                        //展示全部商家和影片
                        GetallMovies();
                        break;
                    case "2":
                        //2展示已看影片
                        HaveSeen();
                        break;
                    case "3":
                        //根据电影名查询影片
                        GetqueryMovie();
                        break;
                    case "4":
                        //评分功能
                        ScoringFunction();
                        break;
                    case "5":
                        //购票买票功能
                        PuyTicket();
                        break;
                    case "6":
                        //充值功能
                        TopUp();
                        break;
                    case "7":
                        //退出系统
                        System.out.println("退出系统欢迎再来~~");
                        return;
                    default:
                        System.out.println("没有这个命令,请重新输入");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("用户展示页面异常");
        }
    }

    /**用户展示已看影片
     *
     */
    private static void HaveSeen() throws Exception {
        System.out.println("-----本用户已看影片有以下-----");
        List<Movie> movies = Customerss.get(loguser);
        if (movies.size() > 0) {
            for (Movie movie : movies) {
                System.out.println("电影片名:" + movie.getName() + "\t\t主演:" + movie.getActor() + "\t\t\t评分:" + movie.getScore() + "\t\t\t时间:"
                        + movie.getTime() + "分钟\t\t票价:" + movie.getPrice() + "\t\t余票数:" + movie.getNumber() + "\t\t\t放映时间:" +
                        sdf.format(movie.getStartTime()));
            }
        } else {
            System.out.println("没有电影,请买票");

        }
    }
    /**
     * 用户 评分功能
     */
    private static void ScoringFunction() throws Exception {

        while (true) {
            System.out.println("----用户评分功能页面--------");
            HaveSeen();
            List<Movie> movies = Customerss.get(loguser);
            for (Movie movie : movies) {
                System.out.println("给自己电影打分功能");
                System.out.println("请输入已看电影");
                String name = sc.nextLine();
                //展示本用户所有电影名
                if (movie.getName().contains(name)) {
                    //输入电影名字和电影名字一样.
                    System.out.println("请给自己电影打分0-10分.");
                    String score = sc.nextLine();
                    //计算一下评分的平均分
                    Set<Map.Entry<Business, List<Movie>>> entries = Businesss.entrySet();
                    for (Map.Entry<Business, List<Movie>> entry : entries) {
                        List<Movie> value = entry.getValue();
                        //最高价格排序
                        java.util.DoubleSummaryStatistics s = value.stream().
                                collect(Collectors.summarizingDouble(Movie::getScore));
                        movie.setScore(movie.getScore() + Double.valueOf(score));
                                           //平均值
                        double v = new BigDecimal(s.getAverage()).divide(BigDecimal.valueOf(1),
                                2, RoundingMode.HALF_UP).doubleValue();
                        System.out.println("谢谢您的好评.您评了" + score + "分" + "平均分是:" +v);
                        break;
                    }
                        System.out.println("请还继续评分吗?y/n");
                    String command = sc.nextLine();//命令
                    switch (command) {
                        case "y":
                            break;
                        default:
                            System.out.println("好的");
                            return;
                    }

                } else {
                    System.out.println("没有此电影");
                    return;
                }
            }
        }
    }


    /**
     * 用户会员 已看电影名
     *
     * @param
     * @return
     */
    private static Movie HaveSeenMovie() {
        List<Movie> movies = Customerss.get(loguser);
        for (Movie movie : movies) {
            return movie;
        }
        return null;
    }


    /**
     * 用户 购票 买票功能
     */
    private static void PuyTicket() throws Exception {
        try {
            GetallMovies();
            System.out.println("------展示购票功能页面-------");
            while (true) {
                System.out.println("请输入购买的影片名");
                String name = sc.nextLine();
                //判断有没有该影片
                Movie movie = FindAMovie(name);
                if (movie != null) {
                    //用户还可以多少买多少张票?
                    System.out.println("提示:影片只剩下" + movie.getNumber() + "张票.");
                    while (true) {
                        System.out.println("请您购买的张票");
                        String number = sc.nextLine();
                        //判断movie票数>=要买的票数
                        if (movie.getNumber() >= Integer.valueOf(number)) {
                            //影片总价
                            double allPrime = BigDecimal.valueOf(movie.getPrice()).multiply(BigDecimal.
                                    valueOf(Integer.valueOf(number))).doubleValue();
                            //判断用户余额>=影片总价
                            if (loguser.getMoney() >= allPrime) {

                                //电影总票-要买的票数=剩下多少票数
                                int numbermoney1 = BigDecimal.valueOf(movie.getNumber()).subtract(BigDecimal.valueOf(Integer.valueOf(number))).intValue();
                                //更新电影票数
                                movie.setNumber(numbermoney1);

                                //更新用户余额
                                double money = BigDecimal.valueOf(loguser.getMoney()).subtract(BigDecimal.valueOf(allPrime)).doubleValue();
                                loguser.setMoney(money);

                                //更新商家余额
                                Business business = allbucsinessess(name);

                                business.setMoney(business.getMoney() + allPrime);

                                List<Movie> cmovies = Customerss.get(loguser);
                                cmovies.add(movie);


                                System.out.println("您成功购买了" + number + "张票" + "总价是:" + allPrime + "元钱");
                                System.out.println("成功购买了电影片名:" + movie.getName() + "\t\t\t主演:" + movie.getActor() + "\t\t\t评分:" + movie.getScore() + "\t\t\t分钟:"
                                        + movie.getTime() + "\t\t票价:" + movie.getPrice() + "\t\t余票数:" + movie.getNumber() + "\t\t\t放映时间:" +
                                        sdf.format(movie.getStartTime()));

                                return;

                            } else {
                                System.out.println("余额不足,剩下" + loguser.getMoney() + "元钱,请充值.");
                                System.out.println("请还继续购票吗?y/n");
                                String command = sc.nextLine();//命令
                                switch (command) {
                                    case "y":
                                        TopUp();
                                        break;
                                    default:
                                        System.out.println("好的");
                                        return;
                                }

                            }
                        } else {
                            System.out.println("此影片票数已满,剩下" + movie.getNumber() + "张票.");
                            System.out.println("请还继续购票吗?y/n");
                            String command = sc.nextLine();//命令
                            switch (command) {
                                case "y":

                                    break;
                                default:
                                    System.out.println("好的");
                                    return;

                            }
                        }
                    }
                } else {
                    System.out.println("没该影片");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("用户充值与购票买票功能异常");
        }
    }

    /**
     * 充值功能
     */
    private static void TopUp() throws Exception {
        while (true) {
            System.out.println("------展示充值功能页面-------");
            System.out.println("你当前余额是:" + loguser.getMoney() + "元.请充值");
            System.out.println("请您输入充值金额?");
            String movie = sc.nextLine();
            //当前金额+充值金额
            double money1 = Double.valueOf(loguser.getMoney()) + Double.valueOf(movie);

            loguser.setMoney(money1);
            System.out.println(loguser.getLoginName() + "您成功充值" + Double.valueOf(movie) + "元钱");
            System.out.println("您当前一共" + money1 + "元钱");
            System.out.println("还要充值吗? y/n");
            String command = sc.nextLine();//命令
            switch (command) {
                case "y":

                    break;
                default:
                    System.out.println("好的");
                    return;

            }
        }
    }


    /**
     * 用户 展示全部影片 allmovies是全部影片
     */
    private static void GetallMovies() throws Exception {
        System.out.println("------用户展示全部商家和影片--------");
        Set<Map.Entry<Business, List<Movie>>> entries = Businesss.entrySet();
        for (Map.Entry<Business, List<Movie>> entry : entries) {
            List<Movie> value = entry.getValue();
            Collections.sort(value, new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    double time = o2.getScore() - o1.getScore();//评分
                    time = time == 0 ? o2.getPrice() - o1.getPrice() : time;//评分一样,按时长排序
                    time = time == 0 ? o2.getTime() - o1.getTime() : time;//评分.时长一样,按名字排序
                    if (time > 0) {
                        return 1;
                    } else if (time < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });
            for (Movie movie : value) {
                System.out.println("电影片名:" + movie.getName() + "\t\t主演:" + movie.getActor() + "\t\t\t评分:" + movie.getScore() + "\t\t\t时间:"
                        + movie.getTime() + "分钟\t\t票价:" + movie.getPrice() + "\t\t余票数:" + movie.getNumber() + "\t\t\t放映时间:" +
                        sdf.format(movie.getStartTime()));

            }
        }

    }


    /**
     * 用户 根据电影名查询全部影片
     */
    private static void GetqueryMovie() throws Exception {

        try {
            System.out.println("------根据电影名查询全部影片页面--------");
            System.out.println("请输入电影片名");
            String name = sc.nextLine();

            //根据电影名 查找电影
            //找到影片
            Movie movie = FindAMovie(name);
            if (movie != null) {
                System.out.println("电影片名:" + movie.getName() + "\t\t主演:" + movie.getActor() + "\t\t\t评分:" + movie.getScore() + "\t\t\t时间:"
                        + movie.getTime() + "分钟\t\t票价:" + movie.getPrice() + "\t\t余票数:" + movie.getNumber() + "\t\t\t放映时间:" +
                        sdf.format(movie.getStartTime()));
            } else {
                System.out.println("查找电影不存在.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("用户 根据电影名查询全部影片异常");

        }

    }


    /**
     * 用户根据电影名 找所有电影返回Movie查找电影
     *
     * @param
     * @return
     */
    private static Movie FindAMovie(String name) throws Exception {
        Set<Map.Entry<Business, List<Movie>>> entries = Businesss.entrySet();
        for (Map.Entry<Business, List<Movie>> entry : entries) {
            List<Movie> value = entry.getValue();
            for (Movie movie : value) {
                if (movie.getName().contains(name)) {
                    return movie;
                }
            }
        }

        return null;
    }

    /**
     * 用户 查询所有的商家 返回存在的business商家
     *
     * @param name
     * @return
     */
    private static Business allbucsinessess(String name) throws Exception {
        // 遍历所有的商家和电影
        Set<Map.Entry<Business, List<Movie>>> entries = Businesss.entrySet();
        if (entries != null) {
            for (Map.Entry<Business, List<Movie>> entry : entries) {
                //遍历所有的电影
                List<Movie> movies = entry.getValue();
                for (Movie movie : movies) {
                    //判断电影是否存在
                    if (movie.getName().contains(name)) {
                        //找到商家
                        Business business = entry.getKey();
                        return business;
                    }
                }
            }
        }

        return null;
    }


}




