//
//  ViewController.swift
//  Groupe1iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.title = "Bonjour"
        Exemple().run()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let segueIdentifier = segue.identifier, segueIdentifier == "toDetailSegue" else {
            return
        }
        
        let detailController = segue.destination as? DetailViewController
        detailController?.theNewText = "Salut man !"
    }
    

}

