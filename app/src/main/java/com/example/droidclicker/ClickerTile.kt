package com.example.droidclicker

import android.widget.Button
import android.widget.ProgressBar

class ClickerTile(/*tapButton: Button,
                  upgradeButton: Button,
                  managerButton: Button,
                  pointBar: ProgressBar*/) {
    var progress: Int = 0
    var clickerIncrementAmt: Int = 1
    var max = 10
    /*var tapButton:Button = tapButton
    var upgradeButton: Button = upgradeButton
    var managerButton: Button = managerButton
    var pointBar: ProgressBar = pointBar*/
    fun tapButton() {
        progress += clickerIncrementAmt
    }
}
