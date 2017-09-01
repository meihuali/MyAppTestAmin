# MyAppTestAmin
Activity 界面跳转 动画 过渡效果轻飘带水波纹的形式 非常给力 研究几天·才搞出来·
 这里分享出来
具体用法 如下
先添加仓库地址 如果你已经添加了仓库了·就别添加了

	maven { url 'https://jitpack.io' }
   
   然后
   添加依赖
    compile 'com.github.meihuali:MyAppTestAmin:V1.1.7'
    
   
   
   然后当然就是 苦逼的程序员代码了·不过我们要的就是 简单便捷·太鸡吧多的代码
   谁看了多会烦·
   所这里 我特此给大家 把各个方法都抽取出来了·封装成 4句很简单的代码 即可 搞定
   酷炫的 界面跳转效果
  
  首先当然是 你点击 某个按钮 要跳转的时候 
  
  那么这里 就 直接copy 这句话
  
  //启动过场动画 注意这里是A activity
  
  第一个参数为intent对象
  
  第二个参数为 当前被点击的onclick 里面的view
  
  第三个参数为 当前类的对象
  
  第四个参数为 当前被点击按钮外城的那个布局的ID
  
  
  Intent intent = new Intent(MainActivity.this,TestActivity.class);
       
  AnimUtils.startIntent(intent,view, (Activity) MainActivity.this,R.id.ll_layoutss);
  
  /************************第二步骤***************************************************************/
  
  
  然后就是目标activity 在oncreate的时候掉用下面这句话 
  
   AnimUtils.animhpel((Activity) this,R.id.ll_layout);
  
  第一个参数为 当前activity对象
  
  第二个参数为 当前对象布局中的根布局，注意这里是最外成 最外层的那个布局
  
  /**************************第三步******************************************************************/
  
  如果按某个按钮返回界面可以调用下面这句 
  
  第一个参数为 当前类的对象
  
  第二个参数为 当前被点击按钮外层的那个布局·注意这里不是最外层的布局哦
  
  第三个参数为 当前点击按钮的view 也就是那个onclick 按钮的view
  
  第四个参数为 最外层的跟布局的ID 最外层记住 最外层
  
  AnimUtils.finishAmins((Activity) TestActivity.this,R.id.ll_xxxx,view,R.id.ll_layout);
  
 /******************************第三步骤**************************************************************/
 
  如果按返回键 可以调用下面代码
  
  第一个参数为 当前类的对象
  
  第二个参数为 当前最外层的那个布局的ID 
     @Override
    public void onBackPressed() {
    
       AnimUtils.finishonBackPressed(SettingsYusanActivity.this,R.id.ll_layoutss);
       
    }
  
  /********************************第四步骤************************************************************/
  
  目标activity背景可以加成白色
 
  android:background="@color/white"
  
  
  /********************************第五步骤********************************************************************/
  
    
  然后在目标activity 的清单配置中加入 这句话
  
  
	   <activity android:name=".TestActivity"
	   
            android:theme="@style/noAnimTheme" （必须要加入这句话）
	  
	  />
	 
