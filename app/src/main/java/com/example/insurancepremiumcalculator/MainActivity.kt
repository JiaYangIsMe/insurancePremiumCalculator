package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myData: PremiumModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData= ViewModelProviders.of(this).get(PremiumModel::class.java)
        display()

        val btn = findViewById<View>(R.id.Calculate)


        Calculate.setOnClickListener(){
            myData.premiumAmount=getPremium()
            display()
        }

        Reset.setOnClickListener(){

                ageSpinner.setSelection(0)

                genderButton.clearCheck()

                smokerYes.setChecked(false)
                Result.text =""

        }

    }

    fun getPremium():Double{
        return when(ageSpinner.selectedItemPosition){
            0->60.00
            1->70.00+
                    (if(maleButton.isChecked) 50.00 else 0.0)+
                    (if(smokerYes.isChecked)100.00 else 0.0)
            2->90.00+
                    (if(maleButton.isChecked) 100.00 else 0.0)+
                    (if(smokerYes.isChecked) 150.00 else 0.0)
            3->120.00+
                    (if(maleButton.isChecked) 100.00 else 0.0)+
                    (if(smokerYes.isChecked) 150.00 else 0.0)//...
            4->150.00+
                    (if(maleButton.isChecked) 100.00 else 0.0)+
                    (if(smokerYes.isChecked) 150.00 else 0.0)
            else->150.00+
                    (if(maleButton.isChecked) 100.00 else 0.0)+
                    (if(smokerYes.isChecked) 150.00 else 0.0)
        }
    }


    fun display(){
        if(myData.premiumAmount !=0.0)
            Result.text="RM "+ myData.premiumAmount.toString()

    }





}
