# # Android10 适配 

## # Android10 DarkTheme
适配思路：

- 跟随系统设置自动适配DarkTheme
- 应用系统级自动适配
- 应用App内手动切换 白天黑夜模式
- 配置适配方案 自行适配

### # 跟随系统设置自动适配DarkTheme

>Android 10 提供 Force Dark 功能。此功能可让开发者快速实现深色主题背景，只需要在 style.xml 中的应用主题中添加这一行代码 android:forceDarkAllowed="true" ，就可以完成自动适配。

```
 <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.DayNight.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="android:forceDarkAllowed">true</item>
    </style>
```

### # 应用App内手动切换 白天黑夜模式

    class ThemeHelper {

    companion object {
        //亮色主题
        const val LIGHT_MODE = "light"

        //黑色主题
        const val DARK_MODE = "dark"

        //默认主题
        const val DEFAULT_MODE = "default"

        /**
         * 应用主题
         * @param themePref
         */
        fun applyTheme(@NonNull themePref: String) {
            when (themePref) {
                LIGHT_MODE -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                DARK_MODE -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                DEFAULT_MODE -> {
                    if (VERSION.SDK_INT >= VERSION_CODES.Q) {
                        //跟随系统Theme 切换主题
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    } else {
                        //根据电量 自动切换
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                    }
                }
            }
        }

        /**
         * 判断深颜色主题是否开启
         */
        fun isNightMode(context: Context): Boolean {
            return (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
        }
   	 }
	}

### # 配置适配方案

- theme `light`
- theme `night`

![](img\01.png)
![](img\02.png)
	
	colors.xml
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
    <color name="color_FFFFFF">#FFFFFF</color>
    <color name="color_000000">#000000</color>
	
	themes.xml 
	<color name="tv_font_color">@color/color_000000</color>
	themes.xml night
	<color name="tv_font_color">@color/color_FFFFFF</color>