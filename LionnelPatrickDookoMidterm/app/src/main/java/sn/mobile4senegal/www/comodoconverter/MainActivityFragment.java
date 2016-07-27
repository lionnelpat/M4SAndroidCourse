package sn.mobile4senegal.www.comodoconverter;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button b;
    private TextInputEditText inputDollar;
    private double val;
    private TextView display;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        b = (Button) rootView.findViewById(R.id.convert);
        inputDollar = (TextInputEditText)rootView.findViewById(R.id.input);
        display = (TextView)rootView.findViewById(R.id.display);


        if (b == null){
            Log.i("MainActivityFragment", "The button is null");
        } else{
            Log.i("MainActivityFragment", "The button is not null");
        }
        b.setOnClickListener( new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if (inputDollar.length() == 0){
                                          inputDollar.requestFocus();
                                          Toast.makeText(getContext().getApplicationContext(), "Inserrez un montant SVP",Toast.LENGTH_SHORT).show();
                                      }else {
                                          val = Double.parseDouble(inputDollar.getText().toString());
                                          val = val * 439.36;
                                          display.setText(String.valueOf(val + " FCFA"));
                                          inputDollar.setText("");
                                      }


                                      Log.i("MainActivityFragment", "The button is clicked!");

                                  }
                              }
        );

        return rootView;

    }

}
