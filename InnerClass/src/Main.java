import java.util.ArrayList;

//抽象メソッドの宣言。SayHelloという名前でこのインターフェイスはhelloというメソッドを持っている「型」的な
//ちなみに抽象メソッドが一つだけなので関数型インターフェイスと呼ぶらしい。
interface SayHello {
	public void hello();
}
interface kazunoko{
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
		//pというPersonを作成。
		Person p = new Person();
		//pというPersonのもつSayHelloをGreetingに渡してその中のgreetを実行、つまりs.helloつまりSysout(こんにちわ)を実行
		Greeting.greet(p);
		Greeting.greet(new Person());
		
		//以下は匿名クラスで作成した場合。greetの引数をいれるところでnew SayHelloと宣言する。
		//そうするとSayHelloインターフェイスを持ったクラスというナニカができるつまり匿名クラス。
		Greeting.greet(new SayHello() {
			public void hello() {
				System.out.println("とくさんか？");
			}
		});
		//以下は「ラムダ式。とくさんの場合」
		Greeting.greet(  ()  -> { System.out.println("ラムダ式でござる");});
		//
		
		
		printout(neko -> neko + 1);
		
		pointList.add(new Point(0, 9));
		pointList.add(new Point(4, 8));
		pointList.add(new Point(3, 55));
		pointList.add(new Point(1, 1));
		
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
	}
}
