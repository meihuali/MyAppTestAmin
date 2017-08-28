# MyAppTestAmin
Activity 界面跳转 动画 过渡效果轻飘带水波纹的形式 非常给力 研究几天·才搞出来·
 这里分享出来
具体用法 如下
先添加仓库地址 如果你已经添加了仓库了·就别添加了

	maven { url 'https://jitpack.io' }
   
   然后
   添加依赖
   compile 'com.github.meihuali:MyAppTestAmin:V1.1.0'
   
   
   然后当然就是 苦逼的程序员代码了·不过我们要的就是 简单便捷·太鸡吧多的代码
   谁看了多会烦·
   所这里 我特此给大家 把各个方法都抽取出来了·封装成 4句很简单的代码 即可 搞定
   酷炫的 界面跳转效果
  
  首先当然是 你点击 某个按钮 要跳转的时候 
   那么这里 就 直接copy 这句话
   
   
                Intent i = new Intent(MainActivity.this, TestActivity.class);
		
                i.putExtra("x", (int)view.getX());
		
                i.putExtra("y", (int)view.getY());
		
                startActivity(i);
                

然后如果你要跳转到的那个 Activity  那么B 这个activity 的话·首先在 oncreate 的时候 直接初始化 
根布局的 ID  那么类型 定位 view 型 例如 

    private View  ll_layout = findViewById(R.id.ll_layout);
    
    然后当然就是我们的核心代码了，初始化完毕 B 这个activity的跟布局以后  那么接着在这个acitivit oncreate
    里面就写上核心代码 
    
         AnimUtils.animhpel((Activity) this,ll_layout);
	 
	 然后点击某个 按钮 返回到上一个acitivity的话核心代码就是 
	 
	  AnimUtils.finshAnim(true,(int)view.getX(),(int)view.getY());
	  
	  
