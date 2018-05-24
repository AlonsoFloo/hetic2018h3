//
//  Forecast.swift
//  Groupe2iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation
import SwiftyJSON

class Forecast {
    var minimumTemperature: Float
    var maximumTemperature: Float
    var descriptionText: String
    var icon: String!
    
    init(minimumTemperature: Float, maximumTemperature: Float, descriptionText: String) {
        self.minimumTemperature = minimumTemperature
        self.maximumTemperature = maximumTemperature
        self.descriptionText = descriptionText
    }
}

extension Forecast {
    convenience init(jsonObject: JSON) {
        let minimumTemperature = jsonObject["main"]["temp_min"].floatValue
        let maximumTemperature = jsonObject["main"]["temp_max"].floatValue
        
        let weatherObject = jsonObject["weather"].arrayValue.first ?? JSON()
        
        let descriptionText = weatherObject["description"].stringValue
        
        self.init(minimumTemperature: minimumTemperature, maximumTemperature: maximumTemperature, descriptionText: descriptionText)
        
        self.icon = weatherObject["icon"].stringValue
    }
}

