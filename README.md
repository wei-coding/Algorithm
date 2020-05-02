# Algorithm

這裡會簡單紀錄演算法的作業和製作心得

## 第一次作業:ArrayData

簡單來講只是讓大家確定可以上傳和批改作業而已，但因為我們發現系統會以`root`權限來執行我們的程式，於是就開始幹一些壞壞的事了

### ADT
還是先寫一下ADT好了
```java=
public abstract class ArrayData {
	public int [] A;
	public abstract int max();
	public abstract int min();
}
```
總之功能非常簡單，只是要找A陣列裡面的最大和最小值而已

### 抓檔案目錄

原本@Hadname只是要抓當前目錄的所有.java檔，但他忘了助教是用**Linux**來建立系統的，於是程式不斷的用`..`來遞迴到上層目錄，以至於當天伺服器花了30幾分鐘才處理完整個資料夾，也拜他使用Thread所賜，沒有Timeout也沒被發現

### import被全面封殺

因為玩到後面有點良心不安，於是我們有跟教授回報這件事情，教授也說因為這只是第一次作業，所以他並沒有開啟外部引用保護，也就是不能使用函式庫的功能，經過我們的提醒之後，第二次作業的函式庫功能就被完全封鎖了，連不import直接使用也被封殺，至此風波也才全部結束。

## 第二次作業:ThreeSum

照慣例，先上ADT

### ADT
```java=
public abstract class ThreeSum {
	public abstract int T_sum(int[] A);
}
```

這次的目標也很簡單，只要找出A陣列中3個數字加起來是0的有幾組即可。

### $N^2logN$ 的算法

其實在上課途中，教授即有簡單介紹過TwoSum的算法了，先排序過後，對每一個數字做他的互補數的二分搜尋，即複雜度~$NlogN$，再對每個數做一次TwoSum就會是ThreeSum，複雜度$N^2logN$

### 前進$N^2$

稍微思考過後發現，其實以排序過的陣列來說，我們可以令三數為a,b,c。固定a，b從a的左側開始搜尋，c從陣列尾端往回搜尋。如果a+b+c>0，可以確定c一定太大了，所以c要往左側移動，反過來，若a+b+c<0，則可以確定是b太小，於是將b往右移動，重複動作直到b,c相遇，然後換下一個a。利用這個方式就可以將複雜度降到$N^2$了

### 開外掛了?



## 第三次作業:IslandCounting

### ADT

```java=
public abstract class IslandCounting {
	public abstract int count(String[] A, String[] B);
}
```
這次的難度就明顯比前兩次來得高了，給定兩個`String`型別陣列A跟B，A和B的相同index對應表示兩島嶼之間有聯繫，目標是算出共有幾個互不相聯的島群

### 初始想法

因為給定的A和B不一定是數字或純英文字，所以一開始想到是用map來幫`String`和`int`間做對應，就可以使用`int`陣列來存放圖的結構(或是將對應關係化成樹)

### 材料

1. 自製HashMap
2. 一個`int[]`來存放對應關係
3. Weighted quick union find

### 插曲:伺服器掛了?

在2020/4/4早上，起床打算看一下前一天演算法的成績，結果出現了:
![](https://i.imgur.com/IDFK2jo.png)

額，前一天還正常的登入，怎麼可能今天就錯了?<br>

當天9:33分

![](https://i.imgur.com/Wdn6u1h.png)

我還以為是神X之塔呢

![](https://i.imgur.com/xtUuX4S.png)

總之，到現在4/5 21:08 還是沒有修復好，就再等等吧

### 掛掉的伺服器始末

