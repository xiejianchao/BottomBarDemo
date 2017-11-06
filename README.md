# BottomBarDemo
应用Bottom navigation + fragment的简单示例

Google官方对Bottom navigation规范描述：https://www.google.com/design/spec/components/bottom-navigation.html

可以官方并没有给出具体实现，只是给出了规范
本示例使用的第三方Bottom navigation库为：https://github.com/roughike/BottomBar

# update 2017-11-07
在Fragment中嵌套ViewPager，ViewPager中是fragment，再嵌套RecyclerView <br>
不需要自定义View和拦截任何手势事件，完美实现在Fragment中嵌套ViewPager再嵌套RecyclerView.
