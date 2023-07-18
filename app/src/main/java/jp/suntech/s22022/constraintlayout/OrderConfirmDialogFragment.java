package jp.suntech.s22022.constraintlayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title", "");
        String name = getArguments().getString("name", "");
        String mail = getArguments().getString("mail", "");
        String comment = getArguments().getString("comment", "");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("タイトル：" + title)
               .setMessage(name + " " + mail + "\n" + comment)
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int id) {
                       dialogInterface.dismiss();
                   }
               });

        AlertDialog dialog = builder.create();
        return dialog;
    }
}