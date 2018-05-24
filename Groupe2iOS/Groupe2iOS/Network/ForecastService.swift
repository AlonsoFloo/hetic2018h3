//
//  ForecastService.swift
//  Groupe2iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

typealias ForecastResult = (_ results: [Forecast]) -> Void
typealias ForecastError = (_ error: Error) -> Void

class ForecastService {
    
    static func fetchForecasts(success: @escaping ForecastResult, failure: @escaping ForecastError) {
        
        let url = UrlBuilder.forecastsUrl
        
        Alamofire.request(url).responseJSON { (response) in
            switch response.result {
            case .success(let value):
                
                // Parsing du JSON
                let jsonRootObject = JSON(value)
                
                let list = jsonRootObject["list"].arrayValue
                
                var forecasts = [Forecast]()
                
                for jsonObject in list {
                    let forecast = Forecast(jsonObject: jsonObject)
                    
                    forecasts.append(forecast)
                }
                
                // Appel au callback
                success(forecasts)
                
                break
            case .failure(let error):
                
                failure(error)
                
                break
            }
        }
        
        
    }
    
}
