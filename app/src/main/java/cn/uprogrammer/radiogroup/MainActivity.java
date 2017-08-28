package cn.uprogrammer.radiogroup;

import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgp;
    private RadioButton femaleBtn;
    private RadioButton maleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      强行转换视图对象
        rgp=(RadioGroup)findViewById(R.id.radioGroupid);
        femaleBtn=(RadioButton)findViewById(R.id.female);
        maleBtn=(RadioButton)findViewById(R.id.male);

//        CompoundButton.OnCheckedChangeListener监听器的不一样
        femaleBtn.setOnCheckedChangeListener(new RadioButtonListerner());
//      监听rgp按钮对象；group 是RGP本身；checkedId是rgp的RadioButton的ID
        rgp.setOnCheckedChangeListener(new RadioGroupListener());

    }
    class RadioButtonListerner implements CompoundButton.OnCheckedChangeListener{
         @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            System.out.println("Checked---》"+isChecked);
        }
    }
    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            if(checkedId==femaleBtn.getId()){
                System.out.println("Select femaleBtn");
            }else if(checkedId==maleBtn.getId()){
                System.out.println("Select maleBtn");
            }
        }
    }
}
