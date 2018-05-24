//
//  ContactDetailViewController.swift
//  Groupe1iOS
//
//  Created by Yvan Moté on 24/05/2018.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class ContactDetailViewController: UIViewController {

    static let identifier = "contactDetailSegueIdentifier"
    
    var contact: Contact!
    // Attention didSet impossible dans le ViewController (problème avec le cycle de vie => chargement de vue)
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.title = contact.firstName+" "+contact.lastName
    }


}
