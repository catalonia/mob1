//
//  ShowWebVC.m
//  TasteSync
//
//  Created by HP on 3/11/14.
//  Copyright (c) 2014 TasteSync. All rights reserved.
//

#import "ShowWebVC.h"

@interface ShowWebVC ()<UIWebViewDelegate>
{
    __weak IBOutlet UIWebView* _webView;
    __weak IBOutlet UIActivityIndicatorView* _activityIndicate;
    NSString* _url;
}
@end

@implementation ShowWebVC

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}
-(id)initWithURL:(NSString*)url
{
    self = [super initWithNibName:@"ShowWebVC" bundle:nil];
    if (self) {
        _url = url;
    }
    return self;
}
- (void)viewDidLoad
{
    [super viewDidLoad];
    [self loadWebview];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
-(void)loadWebview
{
    NSURL* url = [NSURL URLWithString:_url];
    NSURLRequest* request = [NSURLRequest requestWithURL:url];
    [_webView setScalesPageToFit:YES];
    [_activityIndicate startAnimating];
    [_webView loadRequest:request];
}

- (void)webViewDidFinishLoad:(UIWebView *)theWebView
{
    [_activityIndicate stopAnimating];
    [_activityIndicate removeFromSuperview];
}
-(IBAction)backAction:(id)sender
{
    [self dismissViewControllerAnimated:YES completion:nil];
}
@end
