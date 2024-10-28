import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.IntBinaryOperator;

//抽象メソッドの宣言。SayHelloという名前でこのインターフェイスはhelloというメソッドを持っている「型」的な
//ちなみに抽象メソッドが一つだけなので関数型インターフェイスと呼ぶらしい。
interface SayHello {
	public void hello();
}
interface kazunoko{
	//kazunokoは
	public int doSomething(int neko);
}
class Greeting{
	static void greet(SayHello s) {
		//↑SayHelloを持つオブジェクトをsという引数で受け取れる、でsのhelloを実行させる処理が下の文
		s.hello();
	}
}
//SayHelloを受け継いだPersonというクラスを作成
class Person implements SayHello{
	//helloをオーバーライド。インターフェイスの時点ではメソッドがあるだけでごわす。
	public void hello() {
		//Personのhelloにだけこんにちわ出力を追加する。
		System.out.println("こんにちわ");
	}
}

public class Main{
	static void printout(kazunoko i) {
		System.out.println(i.doSomething(2));
		}

	public static void main(String[] args) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		HashMap<String,String> map = new HashMap<String, String>();
		HashSet<String> set = new HashSet<String>();
		//setにセットをaddを試みる。成功した場合trueが返ってくる。のでtrueがsysoutされる。
		System.out.println(set.add("セット"));
		//setにセットが含まれているかどうかを調べる。あればtrueが返ってくるので　trueがsysoutされる
		System.out.println(set.contains("セット"));
		//pというPersonを作成。
		Person p = new Person();
		//pというPersonのもつSayHelloをGreetingに渡してその中のgreetを実行、つまりs.helloつまりSysout(こんにちわ)を実行
		Greeting.greet(p);
		Greeting.greet(new Person());
		
		//以下は匿名クラスで作成した場合。greetの引数をいれるところでnew SayHelloと宣言する。
		//そうするとSayHelloインターフェイスを持ったクラスという[ナニカ]ができるつまり[匿名]クラス。
		Greeting.greet(new SayHello() {
			public void hello() {
				System.out.println("とくさんか？");
			}
		});
		//以下は「ラムダ式。とくさんの場合」
		Greeting.greet(  ()  -> { System.out.println("ラムダ式でござる");});
		//
		IntBinaryOperator shimaji = (a,b) -> a + b;
		IntBinaryOperator sumichan = (a,b) -> a * b;
		System.out.println("足し算(shimaji 10+5=)" + shimaji.applyAsInt(10,5));
		System.out.println("掛け算(sumichan 10*5=)" + sumichan.applyAsInt(10, 5));
		printout(neko -> neko + 1);
		
		pointList.add(new Point(0, 9));
		pointList.add(new Point(4, 8));
		pointList.add(new Point(3, 55));
		pointList.add(new Point(1, 1));
		map.put("名前","田所浩二");
		map.put("年齢","24歳");
		map.put("職業", "学生");
		map.put("恋人関係", "今はいない");
		for (Point po : pointList) {
			po.x *= 2;
			po.y *= 2;
		}
		for (Point po : pointList) {
			po.printInfo();
		}
		pointList.forEach(pp -> {pp.x *= 4;pp.y *= 4;});
		pointList.forEach(pp -> pp.printInfo());
		pointList.sort((p0,p1) -> (p0.x + p0.y) - (p1.x + p1.y));
		pointList.forEach(pp -> pp.printInfo());
		System.out.println(map.entrySet());
		System.out.println("文字を入力してください。");
		InputStreamReader inin = new InputStreamReader(System.in);
		BufferedReader rere = new BufferedReader(inin);
		try {
		String line = rere.readLine();
		System.out.println("あなたが入力したのは" + line + "ですね？" );
		rere.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("数字を入力して臭い！臭い！");
		InputStreamReader suji = new InputStreamReader(System.in);
		BufferedReader sususu = new BufferedReader(suji);
		try {
			String stst = sususu.readLine();
			double val = Double.parseDouble(stst);
			System.out.println("入力された数字は" + val);
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
