package test.liuwangfang.com.reviewproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(this);
        new MyTask().execute();
    }

    @Override
    public void onClick(View view) {

        /**
        taskaffinify相同时,打开mainactivty--secondactivity--mainactivity-secondactivity  最终的栈里顺序为mainactivty--secondactivity
         1. 打开mainactivity
         *   TaskRecord{b90014ad0 #252 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{2042f3ed0 u0 test.liuwangfang.com.reviewproject/.MainActivity t252}

          2. 打开secondactivity
         TaskRecord{b90014ad0 #252 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=2}
         Run #3: ActivityRecord{5be4372d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t252}
         Run #2: ActivityRecord{2042f3ed0 u0 test.liuwangfang.com.reviewproject/.MainActivity t252}

         3.打开mainactivity
         TaskRecord{b90014ad0 #252 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=3}
         Run #4: ActivityRecord{f730d96d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t252}
         Run #3: ActivityRecord{5be4372d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t252}
         Run #2: ActivityRecord{2042f3ed0 u0 test.liuwangfang.com.reviewproject/.MainActivity t252}

         4.打开secondactivity
         TaskRecord{b90014ad0 #252 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=2}
         Run #3: ActivityRecord{6207e7ad0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t252}
         Run #2: ActivityRecord{2042f3ed0 u0 test.liuwangfang.com.reviewproject/.MainActivity t252}

         SecondActivity 已存在,移动到栈顶,并重建(clear_top)
         *
         *
         ====taskaffinify不同时,打开mainactivty--secondactivity--mainactivity-secondactivity  最终的两个栈===
         1.打开mainactivity
         TaskRecord{2578a9cd0 #249 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{24b6770d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t249}

         2.打开secondactivity
         TaskRecord{37f8ca0d0 #250 A=com.test U=0 StackId=1 sz=1}
         Run #3: ActivityRecord{8d09134d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t250}
         TaskRecord{2578a9cd0 #249 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{24b6770d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t249}
         TaskRecord{c81ee42d0 #228 A=com.sec.android.app.clockpackage U=0 StackId=1 sz=1}

         3.打开mainactivity
         TaskRecord{37f8ca0d0 #250 A=com.test U=0 StackId=1 sz=2}
         Run #4: ActivityRecord{354af64d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t250}
         Run #3: ActivityRecord{8d09134d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t250}
         TaskRecord{2578a9cd0 #249 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{24b6770d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t249}

         4.打开secondactivity
         Running activities (most recent first):
         TaskRecord{37f8ca0d0 #250 A=com.test U=0 StackId=1 sz=1}
         Run #3: ActivityRecord{b67335cd0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t250}
         TaskRecord{2578a9cd0 #249 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{24b6770d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t249}

         SecondActivity 已存在,移动到栈顶,并重建(clear_top)

         */

//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);


        /**
         taskaffinify相同时,打开mainactivty--secondactivity--mainactivity-secondactivity
         1. 打开mainactivity
         TaskRecord{bcb0909d0 #254 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #3: ActivityRecord{4bbe90dd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t254}

         2. 打开secondactivity
         TaskRecord{bcb0909d0 #254 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=2}
         Run #4: ActivityRecord{d431af4d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t254}
         Run #3: ActivityRecord{4bbe90dd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t254}

         3.打开mainactivity
         TaskRecord{bcb0909d0 #254 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=3}
         Run #5: ActivityRecord{a8a9c51d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t254}
         Run #4: ActivityRecord{d431af4d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t254}
         Run #3: ActivityRecord{4bbe90dd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t254}

         4.打开secondactivity
         TaskRecord{bcb0909d0 #254 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=4}
         Run #6: ActivityRecord{7a6e045d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t254}
         Run #5: ActivityRecord{a8a9c51d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t254}
         Run #4: ActivityRecord{d431af4d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t254}
         Run #3: ActivityRecord{4bbe90dd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t254}

         taskaffinify相同时 FLAG_ACTIVITY_NEW_TASK 与standard效果相同
         *
         *
         ====taskaffinify不同时,打开mainactivty--secondactivity--mainactivity-secondactivity
         1.打开mainactivity
         TaskRecord{512b515d0 #255 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{84cac59d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t255}

         2.打开secondactivity
         TaskRecord{3aaac9dd0 #256 A=com.test U=0 StackId=1 sz=1}
         Run #3: ActivityRecord{a1ebb61d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t256}
         TaskRecord{512b515d0 #255 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{84cac59d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t255}

         3.打开mainactivity
         TaskRecord{3aaac9dd0 #256 A=com.test U=0 StackId=1 sz=2}
         Run #4: ActivityRecord{b8b0da4d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t256}
         Run #3: ActivityRecord{a1ebb61d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t256}
         TaskRecord{512b515d0 #255 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #2: ActivityRecord{84cac59d0 u0 test.liuwangfang.com.reviewproject/.MainActivity t255}

         4.打开secondactivity
         打不开了。
         为什么呢？是因为此时SecondActivity实例已经存在，但是它所在的task的栈顶是MainActivity；而单独的添加FLAG_ACTIVITY_NEW_TASK又不会"删除task中位于SecondActivity之上的Activity实例"，所以就没有发生跳转！
         */

//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);


        /**
         *  taskaffinify相同时,打开mainactivty--secondactivity--mainactivity-secondactivity
         1. 打开mainactivity
         TaskRecord{7c2c21bd0 #291 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=1}
         Run #4: ActivityRecord{2fbd4ffd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t291}

         2. 打开secondactivity
         Running activities (most recent first):
         TaskRecord{7c2c21bd0 #291 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=2}
         Run #4: ActivityRecord{34367d2d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t291}
         Run #3: ActivityRecord{2fbd4ffd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t291}

         3.打开mainactivity
         Running activities (most recent first):
         TaskRecord{7c2c21bd0 #291 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=3}
         Run #5: ActivityRecord{cf09bced0 u0 test.liuwangfang.com.reviewproject/.MainActivity t291}
         Run #4: ActivityRecord{34367d2d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t291}
         Run #3: ActivityRecord{2fbd4ffd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t291}


         4.打开secondactivity
         TaskRecord{7c2c21bd0 #291 A=test.liuwangfang.com.reviewproject U=0 StackId=1 sz=2}
         Run #4: ActivityRecord{e5fcae1d0 u0 test.liuwangfang.com.reviewproject/.SecondActivity t291}
         Run #3: ActivityRecord{2fbd4ffd0 u0 test.liuwangfang.com.reviewproject/.MainActivity t291}


         SecondActivity 已存在,移动到栈顶,并重建
         */
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    class MyTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            String name = getApplication().getApplicationContext().getString(R.string.app_name);
            Log.i("lwf", "name==" + name);
            return null;
        }
    }
}
