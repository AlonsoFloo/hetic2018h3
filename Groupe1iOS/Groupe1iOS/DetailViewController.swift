//
//  DetailViewController.swift
//  Groupe1iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var myLabel: UILabel!
    @IBOutlet weak var myButton: UIButton!
    
    var theNewText: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        myButton.setTitleColor(UIColor.purple, for: .normal)
        myLabel.text = theNewText
    }
    
    @IBAction func didTapOnButton(_ sender: Any) {
        print("Salut")
    }
}
