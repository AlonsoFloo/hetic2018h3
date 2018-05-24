//
//  ForecastDetailViewController.swift
//  Groupe2iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class ForecastDetailViewController: UIViewController {

    static let identifier = "forecastDetailIdentifier"
    
    var forecast: Forecast!
    // pas de didSet possible dans le ViewController : trust me, I'm an iOS Software engineer 🤓
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.title = forecast.descriptionText
    }
}
