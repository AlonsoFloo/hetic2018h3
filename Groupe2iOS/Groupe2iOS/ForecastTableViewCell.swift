//
//  ForecastTableViewCell.swift
//  Groupe2iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit
import Alamofire
import AlamofireImage

class ForecastTableViewCell: UITableViewCell {

    static let identifier = "forecastIdentifier"

    @IBOutlet weak var minimumTemperatureLabel: UILabel!
    @IBOutlet weak var maximumTemperatureLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var pictureImageView: UIImageView!
    
    var forecast: Forecast! {
        // Appelé lorsque l'on modifiera la variable forecast
        didSet {
            minimumTemperatureLabel.text = forecast.minimumTemperature.stringValue
            maximumTemperatureLabel.text = forecast.maximumTemperature.stringValue
            descriptionLabel.text = forecast.descriptionText
            
            let pictureUrl = UrlBuilder.pictureUrl(name: forecast.icon)
            
            Alamofire.request(pictureUrl).responseImage { (response) in
                if let image = response.result.value {
                    self.pictureImageView.image = image
                }
            }
            
        }
    }
    
    
}
