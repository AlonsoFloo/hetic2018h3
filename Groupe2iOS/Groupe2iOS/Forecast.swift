//
//  Forecast.swift
//  Groupe2iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation

class Forecast {
    var minimumTemperature: Float
    var maximumTemperature: Float
    var descriptionText: String
    
    init(minimumTemperature: Float, maximumTemperature: Float, descriptionText: String) {
        self.minimumTemperature = minimumTemperature
        self.maximumTemperature = maximumTemperature
        self.descriptionText = descriptionText
    }
}
