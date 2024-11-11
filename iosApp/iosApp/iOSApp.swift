import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        DiConfiguratorKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            HomeScreen()
        }
    }
}
