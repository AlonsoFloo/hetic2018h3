//
//  ViewController.swift
//  Groupe2iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

extension String {
    func isPalindrome() -> Bool {
        return self.lowercased() == String(self.lowercased().reversed())
    }
}

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let text = "Kayak"
        
        text.isPalindrome()
        
        
        
        isPalindrome(text: text)
        
        
    }
    
    func isPalindrome(text: String) -> Bool {
        return text.lowercased() == String(text.lowercased().reversed())
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let segueIdentifier = segue.identifier else {
                return // If no do nothing
        }
        
        switch segueIdentifier {
        case "toDetailSegue":
            let detailController = segue.destination as? DetailViewController
            detailController?.mavariable = "YOLO"
            detailController?.doNothing()
        default:
            break
        }
        
        
    }


}

