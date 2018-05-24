//
//  DetailViewController.swift
//  Groupe2iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {
    
    @IBOutlet weak var myLabel: UILabel!
    @IBOutlet weak var myTableView: UITableView!
    
    var mavariable: String = ""
    
    lazy var forecasts = [Forecast]()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        myLabel.text = "Valeur est : \(mavariable)"
        
        
        /*
        forecasts.append(Forecast(minimumTemperature: 10.0, maximumTemperature: 25.0, descriptionText: "Ensoleillé"))
        forecasts.append(Forecast(minimumTemperature: 17.0, maximumTemperature: 20.0, descriptionText: "Pluvieux"))
        forecasts.append(Forecast(minimumTemperature: 12.0, maximumTemperature: 23.5, descriptionText: "Nuageux"))
        forecasts.append(Forecast(minimumTemperature: 9.0, maximumTemperature: 18.0, descriptionText: "Nuageux"))
        forecasts.append(Forecast(minimumTemperature: 15.0, maximumTemperature: 28.0, descriptionText: "Torride"))
        forecasts.append(Forecast(minimumTemperature: 16.0, maximumTemperature: 29.5, descriptionText: "Orageux"))
        forecasts.append(Forecast(minimumTemperature: 12.0, maximumTemperature: 20.0, descriptionText: "Pluvieux"))
        forecasts.append(Forecast(minimumTemperature: 11.0, maximumTemperature: 20.0, descriptionText: "Ensoleillé"))
        forecasts.append(Forecast(minimumTemperature: 17.0, maximumTemperature: 14.0, descriptionText: "Nuageux"))
        */
        
        ForecastService.fetchForecasts(success: { (forecasts) in
            // 👍
            
            self.forecasts.removeAll() // nettoyage du tableau
            self.forecasts.append(contentsOf: forecasts)  // On Stocke les objets en local
            
            //Refresh
            self.myTableView.reloadData()  // le dataSource va être appelé pour afficher les cellules
            
        }) { (error) in
            // 👎
        }
        
        
    }
    
    func doNothing() {
        print("RIEN FAIT")
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if let identifier = segue.identifier {
            if identifier == ForecastDetailViewController.identifier {
                
                if let forecastDetailViewController = segue.destination as? ForecastDetailViewController, let indexPath = myTableView.indexPathForSelectedRow {
                    
                    let forecast = forecasts[indexPath.row]
                    forecastDetailViewController.forecast = forecast
                }
            }
        }
    }
    
}

extension DetailViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return forecasts.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let forecastCell = tableView.dequeueReusableCell(withIdentifier: ForecastTableViewCell.identifier,
                                                         for: indexPath) as! ForecastTableViewCell
        
        forecastCell.forecast = forecasts[indexPath.row]
        
        return forecastCell
    }
    
    
}








