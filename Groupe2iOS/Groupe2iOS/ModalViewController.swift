//
//  ModalViewController.swift
//  Groupe2iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class ModalViewController: UIViewController {

    @IBOutlet weak var myCloseButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    @IBAction func didTapOnClose(_ sender: Any) {
        self.dismiss(animated: true)
    }
}
