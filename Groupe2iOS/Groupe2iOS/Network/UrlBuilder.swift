//
//  UrlBuilder.swift
//  Groupe2iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation

class UrlBuilder {
    static let forecastsUrl: String = {
       return "https://samples.openweathermap.org/data/2.5/forecast?q=London,us&appid=b6907d289e10d714a6e88b30761fae22"
    }()
    
    static func pictureUrl(name: String) -> String {
        return "https://openweathermap.org/img/w/\(name).png"
    }
    
}
