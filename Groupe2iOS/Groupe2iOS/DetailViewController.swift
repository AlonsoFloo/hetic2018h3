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
    
    var mavariable: String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        myLabel.text = "Valeur est : \(mavariable)"
        
    }
    
    func doNothing() {
        print("RIEN FAIT")
    }

}
