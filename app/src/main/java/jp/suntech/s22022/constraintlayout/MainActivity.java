package jp.suntech.s22022.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.btSend);
        HelloListener listener = new HelloListener();
        btSend.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);

        Button btConfirm = findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);
    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view){
            EditText name = findViewById(R.id.etName);
            EditText title = findViewById(R.id.etMailTitle);
            EditText mail = findViewById(R.id.etMail);
            EditText Comment = findViewById(R.id.etComment);

            //入力された名前文字列を取得
            String nameStr = name.getText().toString();
            String titleStr = title.getText().toString();
            String mailStr = mail.getText().toString();
            String CommentStr = Comment.getText().toString();
            String show = nameStr + mailStr + titleStr + "\n" + CommentStr;

            //タップされた画面部品のidのR値を取得
            int id = view.getId();
            //idのR値に応じて処理を分岐
            if(id==R.id.btSend){
                //メッセージを表示
                Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
            }
            else if(id==R.id.btConfirm){
                OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                Bundle args = new Bundle();
                args.putString("title", titleStr);
                args.putString("name", nameStr);
                args.putString("mail", mailStr);
                args.putString("comment", CommentStr);
                dialogFragment.setArguments(args);
                dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
            }
            else if(id==R.id.btClear) {
                //名前入力欄を空文字に設定
                name.setText("");
                title.setText("");
                mail.setText("");
                Comment.setText("");
            }
        }
    }
}